package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;
/**
 * Clase que modela un enemigo alpha.
 */
public class Infectado_Beta extends Infectado{
	protected final int damageBeta = 10;
	protected final int vidaBeta = 120;
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del enemigo beta.
	 * @param movimiento Movimiento del enemigo beta.
	 */
	public Infectado_Beta(Movimiento movimiento) {
		super(movimiento);
		this.damageFisico = this.damageBeta;
		this.vida = this.vidaBeta;
		this.visitor = new VisitorEnemigoBeta(this);
		this.grafica = new EntidadGrafica_Enemigo_Beta();
	}
	
	public int getVidaMax() {
		return vidaBeta;
	}
	
	/**
	 * Visita al enemigo alpha.
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
