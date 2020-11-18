package logicaEntidades;

import visitor.VisitorEntidad;

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
	public Efecto_Temporal(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad) {
		super(movimiento,grafica,visitor,velocidad);
	}
	
	/**
	 * Retorna la duracion del efecto temporal.
	 * @return duracion del efecto.
	 */
	public int getDuracion() {
		return duracion;
	}
}
