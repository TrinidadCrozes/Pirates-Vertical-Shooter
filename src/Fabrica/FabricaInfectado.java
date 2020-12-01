package Fabrica;

import java.awt.Point;
import java.util.Random;

import logicaEntidades.Infectado;
import logicaJuego.Juego;

/**
 * Clase que modela una fábrica de infectados.
 */
public abstract class FabricaInfectado {
	protected Juego juego;
	protected final int velocidad = 1;
	
	/**
	 * Constructor de la fábrica.
	 * @param juego Juego.
	 */
	public FabricaInfectado(Juego juego) {
		this.juego = juego;
	}
	
	/**
	 * Crea un infectado.
	 * @return Infectado Nuevo infectado.
	 */
	public abstract Infectado crearInfectado();
	
	/**
	 * Retorna la ubicacion inicial del infectado.
	 * @return ubicación del infectado.
	 */
	protected Point obtenerUbicacion() {
		Random rnd = new Random();
		int pos_x = rnd.nextInt(juego.getJFrameJuego().getWidth()-1); 
		Point ubicacion = new Point(pos_x, 0);
		return ubicacion;
	}
		
}
