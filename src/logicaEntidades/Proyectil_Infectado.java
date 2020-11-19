package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del enemigo.
 */
public class Proyectil_Infectado extends Proyectil{
	protected final int poderInfeccion = 10;
	
	/**
	 * Constructor del proyectil del enemigo.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 */
	public Proyectil_Infectado(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
		this.poder = poderInfeccion;
	}
	
	/**
	 * Visita al proyectil del enemigo.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}
