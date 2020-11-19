package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;
/**
 * Clase que modela al premio súper arma sanitaria.
 */
public class Super_Arma_Sanitaria extends Efecto_Temporal {

	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 */
	public Super_Arma_Sanitaria(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
	}
	
	/**
	 * Visita al premio.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}
