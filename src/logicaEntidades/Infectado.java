package logicaEntidades;


import movimientoEntidades.*;

/**
 * Clase que modela un enemigo.
 */
public abstract class Infectado extends Personaje{
	protected int damageFisico;
	
	/**
	 * Constructor del infectado.
	 * @param movimiento Movimiento del infectado.
	 */
	public Infectado(Movimiento movimiento) {
		super(movimiento);
	}
	
	/**
	 * Retorna la cantidad de vida que le quita al jugador al hacer contacto.
	 * @return cantidad de vida que quita.
	 */
	public int getDamageFisico() {
		return damageFisico;
	}
}
