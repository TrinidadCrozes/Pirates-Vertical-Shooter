package logicaJuego;



import java.awt.Rectangle;

import java.util.LinkedList;

import java.util.Random;


import logicaEntidades.Entidad;

import logicaEntidades.Jugador;
import logicaEntidades.Proyectil;
import movimientoEntidades.Movimiento_Enemigo;
import movimientoEntidades.Movimiento_Jugador;

public class MenteJuego extends Juego{

	protected int tiempoCuarentena = 0; 
	protected int tiempoSuperArma = 0; 
	protected boolean jugando = true;
	protected final int velocidadInicial = 1;
	protected int oleadaActual;
	protected final int esperarSigOleada = 50;
	protected int esperar = 0;
	
	@Override
	public void inicializarMapa() {
		
		this.nivel = new Nivel1(this);
		oleadaActual = 1;
		this.objetos_en_el_mapa = new LinkedList<Entidad>();
		inicializarJugador();
		inicializarEnemigos();		
		
	}
	
	/**
	 * Inicializa el jugador del juego.
	 */
	private void inicializarJugador() {
		Movimiento_Jugador mov_jugador = new Movimiento_Jugador(150, 530, velocidadInicial, this.gui_juego.getHeight());
		this.jugador = Jugador.getJugador(mov_jugador, this);
		this.gui_juego.agregarEntidad(this.jugador);
		this.objetos_en_el_mapa.add(this.jugador);
	}
	
	/**
	 * Inicializa la lista de enemigos del juego.
	 */
	private void inicializarEnemigos() {
		this.enemigos = this.nivel.getPrimerOleada();
	}
	
	@Override
	public void jugar() {
		this.start();
	}

	@Override
	public void run() {
		try {
			while (jugando) {

				for (Entidad entidad : objetos_en_el_mapa) {
					entidad.hacer();
				}
				
				if(esperar <= 0) {
					agregarEnemigo();
				}else {
					esperar--;
				}
				
				quitarEntidadesSinVida();
				detectarColisiones();
				enemigosDisparar();
				avanzarNivelOleada();
				
				Thread.sleep(10);
			}
			
			this.gui_juego.repaint();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private void avanzarNivelOleada() {
		if(this.enemigos.isEmpty()) {
			esperar = esperarSigOleada;
			if(this.oleadaActual == 1) {
				this.enemigos = this.nivel.getSegundaOleada();
				this.oleadaActual = 2;
			}else {
				this.nivel = this.nivel.getSiguienteNivel();
				if(this.nivel == null) {
					ganarJuego();
				}else {
					this.enemigos = this.nivel.getPrimerOleada();
					this.oleadaActual = 1;
				}
			}
		}
	}
	
	private void ganarJuego() {
		
	}
	
	private void perderJuego() {
		
	}
	
	/**
	 * Hace que el enemigo lance un proyectil.
	 */
	private void enemigosDisparar() {
		Proyectil proyectil = null;
		Random random = new Random();
		for (Entidad infectados: enemigos) {
			if (random.nextInt(50) == 1) {
				proyectil = infectados.getMovimiento().atacar();
				objetos_en_el_mapa.add(proyectil);
			}
		}
	}

	/**
	 * Detecta las colisiones entre las entidades y las visita.
	 */
	private void detectarColisiones() {
		Entidad entidad1;
		Entidad entidad2;
		for (int i = 0; i < objetos_en_el_mapa.size(); i++) {
			entidad1 = objetos_en_el_mapa.get(i);
			for (int j = i + 1; j < objetos_en_el_mapa.size(); j++) {
				entidad2 = objetos_en_el_mapa.get(j);
				if (colisionaron(entidad1, entidad2)) {
					entidad1.visitar(entidad2.getVisitor());
					entidad2.visitar(entidad1.getVisitor());
				}
			}
		}
	}

	/**
	 * Detecta si dos entidades colisionaron.
	 * @param entidad1 Entidad1.
	 * @param entidad2 Entidad2.
	 * @return True si colisionaron, false en caso contrario.
	 */
	private boolean colisionaron(Entidad entidad1, Entidad entidad2) {
		Rectangle E1 = entidad1.getEntidadGrafica().getJLabel().getBounds();
		Rectangle E2 = entidad2.getEntidadGrafica().getJLabel().getBounds();
		return E1.intersects(E2);
	}

	private void quitarEntidadesSinVida() {
		for (Entidad entidad : objetos_en_el_mapa) {
			if (!entidad.estaVivo()) {
				if(entidad.equals(jugador)) {
					perderJuego();
				}
				objetos_en_el_mapa.remove(entidad);
				enemigos.remove(entidad);
				entidad.getEntidadGrafica().getJLabel().setVisible(false);
				
			}
		}
	}

	/**
	 * Agrega un enemigo al mapa.
	 */
	public void agregarEnemigo() {
		Entidad enemigo_a_agregar = null;
		Random rnd = new Random(0);
		int pos_lista_enemigo;
		
		if (this.enemigos != null && !this.enemigos.isEmpty()) {
			pos_lista_enemigo = rnd.nextInt(this.enemigos.size()-1);
			enemigo_a_agregar = this.enemigos.get(pos_lista_enemigo);
			this.gui_juego.agregarEntidad(enemigo_a_agregar);
		}	
	}
	
	/**
	 * Detiene a los enemigos una cantidad determinada de tiempo.
	 * @param duracion Tiempo que se detienen los enemigos.
	 */
	public void detenerEnemigos(int duracion) {
		for(int i = 0; i < enemigos.size(); i++) {
			Entidad e = enemigos.get(i);
			Movimiento_Enemigo mov = (Movimiento_Enemigo) e.getMovimiento();
			mov.detener();
			tiempoCuarentena = duracion;
		}
	}
	
	/**
	 * Desplaza nuevamente a los enemigos.
	 */
	public void moverEnemigos() {
		for(int i = 0; i < enemigos.size(); i++) {
			Entidad e = enemigos.get(i);
			Movimiento_Enemigo mov = (Movimiento_Enemigo) e.getMovimiento();
			mov.mover();
		}
	}
	
	/**
	 * Activa el arma mejorada del jugador.
	 * @param duracion Arma mejorada.
	 */
	public void cambiarArmaJugador(int duracion) {			
		this.jugador.activarArmaEspecial();
		tiempoSuperArma = duracion;
	}
	
	/**
	 * Desactiva el super arma del jugador.
	 */
	public void desactivarSuperArma() {
		this.jugador.desactivarArmaEspecial();
	}
	
	/**
	 * 
	 * @param e
	 */
	public void insertarObjeto(Entidad e) { //Para qué es esto?
		
	
		
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

