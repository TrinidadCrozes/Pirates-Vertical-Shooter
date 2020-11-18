package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela la poción.
 */
public class Pocion extends Objeto_Precioso{

	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 */
	public Pocion(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad) {
		super(movimiento,grafica,visitor,velocidad);
	}
	
	/**
	 * Visita a la pocion.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visitPocion(this);
	}
}
