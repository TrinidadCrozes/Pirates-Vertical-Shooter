package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela un premio.
 */
public abstract class Premio extends Entidad {
	
	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 */
	public Premio(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad) {
		super(movimiento,grafica,visitor,velocidad);
	}
}
