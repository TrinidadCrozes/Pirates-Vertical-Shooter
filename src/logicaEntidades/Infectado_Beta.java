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
	
	/**
	 * Constructor del enemigo.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param proyectil
	 */
	public Infectado_Beta(Movimiento movimiento, EntidadGrafica grafica, VisitorEntidad visitor, Proyectil proyectil) {
		super(movimiento, grafica, visitor, proyectil);
		this.damageFisico = this.damageBeta;
		this.vida = this.vidaBeta;
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
}
