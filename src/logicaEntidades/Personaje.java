package logicaEntidades;

import graficaEntidades.EntidadGrafica;
import movimientoEntidades.*;

/**
 * Clase que modela un personaje.
 */
public abstract class Personaje extends Entidad {
	/**
	 * Constructor del personaje.
	 * @param movimiento Movimiento del personaje.
	 */
	public Personaje(Movimiento movimiento) {
		super(movimiento);
	}
}
