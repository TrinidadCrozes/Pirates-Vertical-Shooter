package logicaEntidades;



import movimientoEntidades.*;


/**
 * Clase que modela un premio.
 */
public abstract class Premio extends Entidad {
	
	/**
	 * Constructor del premio.
	 * @param movimiento Movimiento del premio.
	 */
	public Premio(Movimiento movimiento) {
		super(movimiento);
	}
	
}
