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
		
		Infectado inf;
		this.enemigos = new LinkedList<Infectado>();	
		FabricaInfectado fabAlpha = new FabricaAlpha(this);
		FabricaInfectado fabBeta = new FabricaBeta(this);
		for(int i = 0; i < nivel.getCantidadEnemigosAlpha(); i++) {
			inf = fabAlpha.crearInfectado(this.gui_juego.getWidth(), this.gui_juego.getHeight());
			enemigos.add(inf);
		}
		for(int i = 0; i < nivel.getCantidadEnemigosBeta(); i++) {
			inf = fabBeta.crearInfectado(this.gui_juego.getWidth(), this.gui_juego.getHeight());
			enemigos.add(inf);
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
				for (Entidad entidad : objetos_en_el_mapa) {
					entidad.hacer();
				}
				Thread.sleep(10);

				quitarEntidadesSinVida();
				detectarColisiones();
				enemigosDisparar();
			}
			this.gui_juego.repaint();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private void enemigosDisparar() {
		Random random = null;
		for (Infectado infectados: enemigos) {
			if (random.nextInt(50) == 1) {
				Proyectil proyectil = infectados.getMovimiento().atacar();
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
			}
		}
	}
	
	

	/**
	 * Agrega un enemigo al mapa.
	 */
	public Point agregarEnemigo() {
		
		Point ubicacion = null;
		Random rnd = new Random(0);
		int pos_x;
		int pos_lista_enemigo;

		if (this.enemigos != null) {
			pos_x = rnd.nextInt(this.gui_juego.getWidth()); 
			pos_lista_enemigo = rnd.nextInt(this.enemigos.size()-1);
			ubicacion = new Point(pos_x, 0);
			this.enemigos.remove(pos_lista_enemigo);
			this.gui_juego.agregarEnemigo(this.enemigos.get(pos_lista_enemigo), ubicacion);
		}
		
		return ubicacion;
		
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


