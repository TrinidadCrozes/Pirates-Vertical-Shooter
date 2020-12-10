package logicaEntidades;

import logicaJuego.Juego;
import movimientoEntidades.*;

/**
 * Clase que modela un personaje.
 */
public abstract class Personaje extends Entidad {
	protected Juego juego;
	
	/**
	 * Constructor del personaje.
	 * @param movimiento Movimiento del personaje.
	 * @param juego Juego.
	 */
	public Personaje(Movimiento movimiento,Juego juego) {
		super(movimiento);
		this.juego = juego;
	}
	
}
