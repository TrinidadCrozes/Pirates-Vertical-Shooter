package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;
import logicaJuego.Juego;

/**
 * Clase que modela un enemigo alpha.
 */
public class Infectado_Alpha extends Infectado{
	protected final int damageAlpha = 15;
	protected final int critico = 20;
	
	/**
	 * Constructor del enemigo alpha.
	 * @param movimiento Movimiento del enemigo.
	 * @param juego Juego.
	 */
	public Infectado_Alpha(Movimiento movimiento,Juego juego) {
		super(movimiento,juego);
		this.damageFisico = damageAlpha;
		this.visitor = new VisitorEnemigoAlpha(this);
		this.grafica = new EntidadGrafica_Enemigo_Alpha((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	/**
	 * Visita al enemigo alpha.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
	
	@Override
	public void estadoCritico() {
		if(vida <= critico) {
			Movimiento mov = new Movimiento_Enemigo_Mejorado((int)this.getMovimiento().getPosicion().getX(),(int)this.getMovimiento().getPosicion().getY(),this.getMovimiento().getAlturaFrame());
			this.movimiento = mov;
			grafica.modificarEtiqueta();
		}
	}

}
