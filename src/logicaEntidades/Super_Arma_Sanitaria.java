package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela al premio súper arma sanitaria.
 */
public class Super_Arma_Sanitaria extends Efecto_Temporal {

	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 */
	public Super_Arma_Sanitaria(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad) {
		super(movimiento,grafica,visitor,velocidad);
	}
	
	/**
	 * Visita al premio.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visitSuper_Arma_Sanitaria(this);
	}
}
