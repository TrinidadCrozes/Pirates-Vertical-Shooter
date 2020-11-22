package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;
/**
 * Clase que modela al premio súper arma sanitaria.
 */
public class Super_Arma_Sanitaria extends Efecto_Temporal {
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del premio super arma sanitaria.
	 * @param movimiento Movimiento del premio.
	 */
	public Super_Arma_Sanitaria(Movimiento movimiento) {
		super(movimiento);
		this.visitor = new VisitorSuperArmaSanitaria(this);
		this.grafica = new EntidadGrafica_SuperArma();
	}
	
	/**
	 * Visita al premio.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		return grafica;
	}
}
