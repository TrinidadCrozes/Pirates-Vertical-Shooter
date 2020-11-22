package logicaEntidades;



import movimientoEntidades.*;


/**
 * Clase que modela un premio.
 */
public abstract class Premio extends Entidad {
	protected boolean colisiono = false;
	
	/**
	 * Constructor del premio.
	 * @param movimiento Movimiento del premio.
	 */
	public Premio(Movimiento movimiento) {
		super(movimiento);
	}
	
	/**
	 * Analiza si el premio ha colisionado contra algo.
	 * @return True si colisiono, false en caso contrario.
	 */
	public boolean Colisiono() {
		return colisiono;
	}
	
	/**
	 * Avisa al premio que colisiono.
	 */
	public void haColisionado() {
		this.colisiono = true;
	}
	
}
