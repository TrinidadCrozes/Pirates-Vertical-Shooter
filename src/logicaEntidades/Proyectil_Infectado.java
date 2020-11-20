package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del enemigo.
 */
public class Proyectil_Infectado extends Proyectil{
	protected final int poderInfeccion = 10;
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del proyectil infectado.
	 * @param movimiento Movimiento del proyectil infectado.
	 */
	public Proyectil_Infectado(Movimiento movimiento) {
		super(movimiento);
		this.poder = poderInfeccion;
		this.visitor = new VisitorProyectilEnemigo(this);
		this.grafica = new EntidadGrafica_Proyectil_Infectado();
	}
	
	/**
	 * Visita al proyectil del enemigo.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}
