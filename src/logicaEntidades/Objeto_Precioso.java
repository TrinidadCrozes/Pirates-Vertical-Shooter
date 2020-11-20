package logicaEntidades;



import movimientoEntidades.*;

/**
 * Clase que modela el tipo de premio objeto precioso.
 */
public abstract class Objeto_Precioso extends Premio{

	/**
	 * Constructor del tipo de premio objeto precioso.
	 * @param movimiento Movimiento del premio.
	 */
	public Objeto_Precioso(Movimiento movimiento) {
		super(movimiento);
	}
}
