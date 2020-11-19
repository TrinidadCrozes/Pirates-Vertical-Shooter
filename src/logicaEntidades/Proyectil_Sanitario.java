package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del personaje principal.
 */
public class Proyectil_Sanitario extends Proyectil{
	protected final int poderDesinfeccion = 10;
	
	/**
	 * Constructor del proyectil del jugador principal.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 */
	public Proyectil_Sanitario(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
		this.poder = poderDesinfeccion;
	}
	
	/**
	 * Visita al proyectil del jugador.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}
