package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela al tipo de premio efecto temporal.
 */
public abstract class Efecto_Temporal extends Premio{
	protected final int duracion = 10;
	
	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 */
	public Efecto_Temporal(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
	}
	
	/**
	 * Retorna la duracion del efecto temporal.
	 * @return duracion del efecto.
	 */
	public int getDuracion() {
		return duracion;
	}
}

