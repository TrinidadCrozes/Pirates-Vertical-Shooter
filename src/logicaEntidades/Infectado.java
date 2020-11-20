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
	 * @param proyectil Proyectil del infectado.
	 */
	public Infectado(Movimiento movimiento,Proyectil proyectil) {
		super(movimiento, proyectil);
	}
	
	/**
	 * Retorna la cantidad de vida que le quita al jugador al hacer contacto.
	 * @return cantidad de vida que quita.
	 */
	public int getDamageFisico() {
		return damageFisico;
	}
}
