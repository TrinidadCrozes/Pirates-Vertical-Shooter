package logicaEntidades;




import movimientoEntidades.*;


/**
 * Clase que modela un proyectil.
 */
public abstract class Proyectil extends Entidad {
	protected int poder;
	
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
	
	@Override
	public void morir() {}
	
	@Override
	public void mover() {}
	
	@Override
	public void estadoCritico() {}
	
	@Override
	public void detener() {}
	
}
