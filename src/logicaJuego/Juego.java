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
public class Juego extends Thread {
	
	protected JFrameJuego gui_juego;
	protected Jugador barco_pirata;
	protected List<Infectado> barcos_enemigos;
	protected List<Entidad> objetos_en_el_mapa;
	protected Nivel nivel;
	
	/**
	 * Inicializa la lógica del juego con los elementos que contendrá el mapa.
	 * @param j JFrameJuego.
	 */
	public Juego(JFrameJuego j) {
		
		this.gui_juego = j;
		inicializarJugador();
		inicializarEnemigos();		
		this.objetos_en_el_mapa = new LinkedList<Entidad>();
		
	}
	
	private void inicializarJugador() {
		
		int mitad_JFrameJuego = (int)(this.gui_juego.getWidth()/2);
		Movimiento_Jugador mov_jugador = new Movimiento_Jugador(mitad_JFrameJuego, 0, 4, this.gui_juego.getHeight());
		Movimiento mov_proyectil_jugador = new Movimiento_Proyectil_Jugador( , , 10, this.gui_juego.getHeight());
		Proyectil proyectil_jugador = new Proyectil_Sanitario(mov_proyectil_jugador);
		this.barco_pirata = Jugador.getJugador(mov_jugador, proyectil_jugador, this);
		
	}
	
	private void inicializarEnemigos() {
		
		this.barcos_enemigos = new LinkedList<Infectado>();		
		FabricaInfectado fabAlpha = new FabricaAlpha(this);
		FabricaInfectado fabBeta = new FabricaBeta(this);
		for(int i = 0; i < nivel.getCantidadEnemigosAlpha(); i++) {
			Infectado inf = fabAlpha.crearInfectado();
			barcos_enemigos.add(inf);
		}
		for(int i = 0; i < nivel.getCantidadEnemigosBeta(); i++) {
			Infectado inf = fabBeta.crearInfectado();
			barcos_enemigos.add(inf);
		}
		
	}
	
	public void run() {
		
		
		
	}
	
	public void keyPressed(KeyEvent arg0) {
		
		Movimiento mov_jugador = this.barco_pirata.getMovimiento();
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
				if ( mov_jugador.puedeMoverse() )
					mov_jugador.moverIzquierda();
				break;
			}
			case KeyEvent.VK_RIGHT: {
				if ( mov_jugador.puedeMoverse() )
					mov_jugador.moverDerecha();
				break;
			}
			//Falta para tirar proyectiles
		}
		this.gui_juego.repaint();
		
	}
	
	/**
	 * 
	 */
	public void agregarEnemigo() {
		
		Point ubicacion;
		Random rnd = new Random(0);
		int pos_x;
		int pos_lista_enemigo;
				
		if (this.barcos_enemigos != null) {
			pos_x = rnd.nextInt(this.gui_juego.getWidth()); 
			pos_lista_enemigo = rnd.nextInt(this.barcos_enemigos.size()-1);
			ubicacion = new Point(pos_x, 0);
			this.objetos_en_el_mapa.add(this.barcos_enemigos.get(pos_lista_enemigo));
			this.barcos_enemigos.remove(pos_lista_enemigo);
			this.gui_juego.agregarEnemigo(ubicacion);
		}
		
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
	
	public void detenerEnemigos(int duracion) {
		
		for(int i = 0; i < barcos_enemigos.size(); i++) {
			Infectado e = barcos_enemigos.get(i);
			Movimiento_Enemigo mov = (Movimiento_Enemigo) e.getMovimiento();
			mov.detener(); //No se como manejar lo de la cant de tiempo que lo detengo
		}
		
	}

	public void cambiarArmaJugador(int duracion) {
				
		barco_pirata.activarArmaEspecial();
		
	}

	public Jugador getJugador() {
		
		return barco_pirata;
		
	}

}

