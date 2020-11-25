package logicaJuego;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import Fabrica.FabricaAlpha;
import Fabrica.FabricaBeta;
import Fabrica.FabricaInfectado;
import logicaEntidades.Entidad;
import logicaEntidades.Infectado;
import logicaEntidades.Jugador;
import logicaEntidades.Proyectil;
import movimientoEntidades.Movimiento_Enemigo;
import movimientoEntidades.Movimiento_Jugador;

public class MenteJuego extends Juego {
	
	protected List mitad_enemigos_1;
	protected List mitad_enemigos_2;
	protected int tiempoCuarentena = 0; 
	protected int tiempoSuperArma = 0; 
	protected boolean jugando = true;
	
	@Override
	public void inicializarMapa() {
		
		this.nivel = new Nivel1();
		this.objetos_en_el_mapa = new LinkedList<Entidad>();
		inicializarJugador();
		inicializarEnemigos();		
		
	}
	
	/**
	 * Inicializa el jugador del juego.
	 */
	private void inicializarJugador() {

		int mitad_JFrameJuego = (int)(this.gui_juego.getWidth()/2);
		Point pos = new Point(mitad_JFrameJuego, 0);	
		Movimiento_Jugador mov_jugador = new Movimiento_Jugador(pos.x, pos.y, 4, this.gui_juego.getHeight());
		this.jugador = Jugador.getJugador(mov_jugador, this);
		this.gui_juego.agregarJugador(this.jugador, pos);
		this.objetos_en_el_mapa.add(this.jugador);
		
	}
	
	/**
	 * Inicializa la lista de enemigos del juego.
	 */
	private void inicializarEnemigos() {
		Infectado inf1;
		Infectado inf2;
		this.enemigos = new LinkedList<Infectado>();	
		FabricaInfectado fabAlpha = new FabricaAlpha(this);
		FabricaInfectado fabBeta = new FabricaBeta(this);
		for(int i = 0; i < this.nivel.getMitadCantidadEnemigos()/2; i++) {
			inf1 = fabAlpha.crearInfectado(this.gui_juego.getWidth(), this.gui_juego.getHeight());
			inf2 = fabAlpha.crearInfectado(this.gui_juego.getWidth(), this.gui_juego.getHeight());
			mitad_enemigos_1.add(inf1);
			mitad_enemigos_2.add(inf2);
			enemigos.add(inf1);
			enemigos.add(inf2);
		}
		for(int i = 0; i < this.nivel.getMitadCantidadEnemigos()/2; i++) {
			inf1 = fabBeta.crearInfectado(this.gui_juego.getWidth(), this.gui_juego.getHeight());
			inf2 = fabBeta.crearInfectado(this.gui_juego.getWidth(), this.gui_juego.getHeight());
			mitad_enemigos_1.add(inf1);
			mitad_enemigos_2.add(inf2);
			enemigos.add(inf1);
			enemigos.add(inf2);
		}		
	}
	
	@Override
	public void jugar() {
		this.start();
	}

	public void run() {

		/* Recorrer la lista de entidades y hacer q se desplacen, evitando el jugador */
		/*
		 * controlar si hay muertos. controlar si hubo colisiones. controlar el estado
		 * de los premios
		 */
		// disparos de enemigos con un random
		try {
			while (jugando) {
				Random random = new Random(0);
				int i = nextInt(20);
				//ver lo de las tandas
				if(!mitad_enemigos_1.isEmpty()) {
					agregarEnemigo();
				}			
				else {
					
				}
				
				for (Entidad entidad : objetos_en_el_mapa) {
					entidad.hacer();
				}
				Thread.sleep(10);
				
				quitarEntidadesSinVida();
				detectarColisiones();
				enemigosDisparar();
				avanzarNivel();
				chequearFinal();
			}
			this.gui_juego.repaint();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private void avanzarNivel() {
		if(this.enemigos.isEmpty()) {
			this.nivel = this.nivel.getSiguienteNivel();
			if(this.nivel != null)
				inicializarEnemigos();
		}
	}
	
	private void chequearFinal() {
		if(!this.jugador.estaVivo()) {
			perder();
			finJuego();
		}
		if(this.nivel == null) {
			ganar();
			finJuego();
		}	
	}
	
	private void finJuego() {
		this.stop();
	}
	
	private void enemigosDisparar() {
		Proyectil proyectil = null;
		Random random = new Random(0);
		for (Infectado infectados: enemigos) {
			if (random.nextInt(50) == 1) {
				proyectil = infectados.getMovimiento().atacar();
				objetos_en_el_mapa.add(proyectil);
			}
		}
	}

	private void detectarColisiones() {
		Entidad entidad1;
		Entidad entidad2;
		for (int i = 0; i < objetos_en_el_mapa.size(); i++) {
			entidad1 = objetos_en_el_mapa.get(i);
			for (int j = i + 1; j < objetos_en_el_mapa.size(); j++) {// desde i+1 para que no se compare
				entidad2 = objetos_en_el_mapa.get(j); // con si mismo y sea mas eficiente

				if (colisionaron(entidad1, entidad2)) {
					entidad1.visitar(entidad2.getVisitor());
					entidad2.visitar(entidad1.getVisitor());

				}
			}

		}
	}

	private boolean colisionaron(Entidad entidad1, Entidad entidad2) {
		Rectangle E1 = entidad1.getEntidadGrafica().getJLabel().getBounds();
		Rectangle E2 = entidad2.getEntidadGrafica().getJLabel().getBounds();
		return E1.intersects(E2);
	}

	private void quitarEntidadesSinVida() {
		for (Entidad entidad : objetos_en_el_mapa) {
			if (!entidad.estaVivo()) {
				objetos_en_el_mapa.remove(entidad);
				entidad.getEntidadGrafica().getJLabel().setVisible(false);
			}
		}
	}
	
	

	/**
	 * Agrega un enemigo al mapa.
	 */
	public void agregarEnemigo() {
		Point ubicacion = null;
		Infectado enemigo_a_agregar = null;
		Random rnd = new Random(0);
		int pos_lista_enemigo;
		
		if (this.enemigos != null) {
			pos_lista_enemigo = rnd.nextInt(this.enemigos.size()-1);
			enemigo_a_agregar = this.enemigos.get(pos_lista_enemigo);
			ubicacion = enemigo_a_agregar.getMovimiento().getPosicion();
			this.gui_juego.agregarEnemigo(enemigo_a_agregar, ubicacion);
			this.enemigos.remove(pos_lista_enemigo);
		}	
	}
	

	public void detenerEnemigos(int duracion) {
		for(int i = 0; i < enemigos.size(); i++) {
			Infectado e = enemigos.get(i);
			Movimiento_Enemigo mov = (Movimiento_Enemigo) e.getMovimiento();
			mov.detener(); //No se como manejar lo de la cant de tiempo que lo detengo
		}
	}

	public void cambiarArmaJugador(int duracion) {			
		this.jugador.activarArmaEspecial();
		//ver lo de la duración
	}
	
	/**
	 * 
	 * @param e
	 */
	public void insertarObjeto(Entidad e) {
		
		
		
	}
	
	/**
	 * 
	 * @param e
	 */
	public void eliminarObjeto(Entidad e) {
		
		if( objetos_en_el_mapa.contains(e) ) {
			objetos_en_el_mapa.remove(e);
		}			
		
	}

}


