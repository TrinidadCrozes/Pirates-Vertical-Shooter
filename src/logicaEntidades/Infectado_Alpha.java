package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un enemigo alpha.
 */
public class Infectado_Alpha extends Infectado{
	protected final int damageAlpha = 15;
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del enemigo alpha.
	 * @param movimiento Movimiento del enemigo.
	 * @param proyectil Proyectil del enemigo.
	 */
	public Infectado_Alpha(Movimiento movimiento,Proyectil proyectil) {
		super(movimiento, proyectil);
		this.damageFisico = damageAlpha;
		this.visitor = new VisitorEnemigoAlpha(this);
		this.grafica = new EntidadGrafica_Enemigo_Alpha();
	}
	
	/**
	 * Visita al enemigo alpha.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
	
	/**
	 * Avisa si el infectado Alpha se encuentra con la vida menor o igual a 20.
	 * @return True si la vida del infectado es menor o igual a 20, false caso contrario.
	 */
	public boolean estadoCritico() {
		return (vida <= 20);
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		return grafica;
	}
}
