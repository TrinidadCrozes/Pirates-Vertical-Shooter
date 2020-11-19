package logicaEntidades;
import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;
/**
 * Clase que modela un enemigo.
 */
public abstract class Infectado extends Personaje{
	protected int damageFisico;
	
	/**
	 * Constructor del enemigo.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param proyectil
	 */
	public Infectado(Movimiento movimiento, EntidadGrafica grafica, VisitorEntidad visitor, Proyectil proyectil) {
		super(movimiento, grafica, visitor, proyectil);
	}
	
	/**
	 * Retorna la cantidad de vida que le quita al jugador al hacer contacto.
	 * @return cantidad de vida que quita.
	 */
	public int getDamageFisico() {
		return damageFisico;
	}
}
