package logicaEntidades;



import movimientoEntidades.*;

/**
 * Clase que modela al tipo de premio efecto temporal.
 */
public abstract class Efecto_Temporal extends Premio{
	protected final int duracion = 10;
	
	/**
	 * Constructor del tipo de premio efecto temporal.
	 * @param movimiento Movimiento del premio.
	 */
	public Efecto_Temporal(Movimiento movimiento) {
		super(movimiento);
	}
	
	/**
	 * Retorna la duracion del efecto temporal.
	 * @return duracion del efecto.
	 */
	public int getDuracion() {
		return duracion;
	}
}


