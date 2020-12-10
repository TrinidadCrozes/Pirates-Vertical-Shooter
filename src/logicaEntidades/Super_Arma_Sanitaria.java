package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;
/**
 * Clase que modela al premio súper arma sanitaria.
 */
public class Super_Arma_Sanitaria extends Efecto_Temporal {
	
	/**
	 * Constructor del premio super arma sanitaria.
	 * @param movimiento Movimiento del premio.
	 */
	public Super_Arma_Sanitaria(Movimiento movimiento) {
		super(movimiento);
		this.visitor = new VisitorSuperArmaSanitaria(this);
		this.grafica = new EntidadGrafica_SuperArma((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	/**
	 * Visita al premio.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}

}
