package logicaJuego;

import logicaEntidades.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Fabrica.*;
import GUI.JFrameJuego;

import java.lang.Thread;
import java.awt.Point;

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
		this.barco_pirata = Jugador.getJugador(null, null, null);
		this.barcos_enemigos = new LinkedList<Infectado>();		
		for(int i = 0; i < nivel.getCantidadEnemigosAlpha(); i++) {
			Infectado inf = FabricaAlpha.crearInfectado();
			barcos_enemigos.add(inf);
		}
		for(int i = 0; i < nivel.getCantidadEnemigosBeta(); i++) {
			Infectado inf = FabricaBeta.crearInfectado();
			barcos_enemigos.add(inf);
		}
		this.objetos_en_el_mapa = new LinkedList<Entidad>();
		
	}
	
	@Override
	public void run() {
		
		
		
	}
	
	/**
	 * 
	 */
	public void agregarEnemigo() {
		
		Point ubicacion;
		Random rnd = new Random(0);
		int pos_x;
		int pos_lista_enemigo;
				
		if (barcos_enemigos != null) {
			pos_x = rnd.nextInt(gui_juego.getWidth()); 
			pos_lista_enemigo = rnd.nextInt(barcos_enemigos.size()-1);
			ubicacion = new Point(pos_x, 0);
			objetos_en_el_mapa.add(barcos_enemigos.get(pos_lista_enemigo));
			barcos_enemigos.remove(pos_lista_enemigo);
			gui_juego.agregarEnemigo(ubicacion);
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
		

		
	}

	public void cambiarArmaJugador(int duracion) {
				
		
		
	}

	public Jugador getJugador() {
		
		return barco_pirata;
		
	}
		

}
