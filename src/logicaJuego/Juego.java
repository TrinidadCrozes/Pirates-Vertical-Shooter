package logicaJuego;

import logicaEntidades.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Fabrica.*;
import GUI.JFrameJuego;
import movimientoEntidades.*;

import java.lang.Thread;
import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 * Clase que implementa la lógica del juego.
 */
public abstract class Juego extends Thread {
	
	protected JFrameJuego gui_juego;
	protected Jugador jugador;
	protected List<Infectado> enemigos;
	protected List<Entidad> objetos_en_el_mapa;
	protected Nivel nivel;
	
	/**
	 * Inicializa el mapa del juego con las componentes necesarias.
	 */
	public abstract void inicializarMapa();
	
	/**
	 * Comienza el juego.
	 */
	public abstract void jugar();
	
	/**
	 * Devuelve el JFrameJuego del juego.
	 * @return JFrameJuego.
	 */
	public JFrameJuego getJFrameJuego() {
		return this.gui_juego;
	}
	
	/**
	 * Asigna el JFrameJuego del juego.
	 * @param frameJuego JFrameJuego a asignar.
	 */
	public void setJFrameJuego(JFrameJuego frameJuego) {
		this.gui_juego = frameJuego;
	}

	/**
	 * Retorna el jugador del juego.
	 * @return Jugador.
	 */
	public Jugador getJugador() {
		return this.jugador;
	}

	public abstract void detenerEnemigos(int duracion);

	public abstract void cambiarArmaJugador(int duracion);


}

