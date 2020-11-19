package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un enemigo alpha.
 */
public class Infectado_Alpha extends Infectado{
	protected final int damageAlpha = 15;
	
	/**
	 * Constructor del enemigo.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 * @param proyectil
	 */
	public Infectado_Alpha(Movimiento movimiento, EntidadGrafica grafica, VisitorEntidad visitor, Proyectil proyectil) {
		super(movimiento, grafica, visitor, proyectil);
		this.damageFisico = damageAlpha;
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
}
