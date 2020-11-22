package logicaEntidades;
import movimientoEntidades.*;


/**
 * Clase que modela un proyectil.
 */
public abstract class Proyectil extends Entidad {
	protected int poder;
	protected boolean colisiono = false;
	
	/**
	 * Constructor del proyectil.
	 * @param movimiento Movimiento del proyectil.
	 */
	public Proyectil(Movimiento movimiento) {
		super(movimiento);
	}
	
	/**
	 * Retorna el poder del proyectil.
	 * @return Poder del proyectil.
	 */
	public int getPoder() {
		return poder;
	}
	
	/**
	 * Obtiene el poder del proyectil.
	 * @param poder Poder del proyectil.
	 */
	public void setPoder(int poder) {
		this.poder = poder;
	}
	
	/**
	 * Analiza si el proyectil ha colisionado contra algo.
	 * @return True si colisiono, false en caso contrario.
	 */
	public boolean Colisiono() {
		return colisiono;
	}
	
	/**
	 * Avisa al proyectil que colisiono.
	 */
	public void haColisionado() {
		this.colisiono = true;
	}
	
	
}
