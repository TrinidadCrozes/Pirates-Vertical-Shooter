package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;
import logicaJuego.Juego;
/**
 * Clase que modela un enemigo alpha.
 */
public class Infectado_Beta extends Infectado{
	protected final int damageBeta = 10;
	protected final int vidaBeta = 120;
	
	/**
	 * Constructor del enemigo beta.
	 * @param movimiento Movimiento del enemigo beta.
	 * @param juego Juego.
	 */
	public Infectado_Beta(Movimiento movimiento,Juego juego) {
		super(movimiento,juego);
		this.damageFisico = this.damageBeta;
		this.vida = this.vidaBeta;
		this.visitor = new VisitorEnemigoBeta(this);
		this.grafica = new EntidadGrafica_Enemigo_Beta((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	@Override
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
	public void estadoCritico() {}
}
