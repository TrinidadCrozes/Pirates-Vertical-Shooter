package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del personaje principal mejorado.
 */
public class Proyectil_Sanitario_Super extends Proyectil_Sanitario{
	protected final int poderDesinfeccionSuper = 20;
	
	/**
	 * Constructor del proyectil mejorado del jugador principal.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 */
	public Proyectil_Sanitario_Super(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
		this.poder = poderDesinfeccionSuper;
	}
	
	/**
	 * Visita al proyectil del jugador mejorado.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}
