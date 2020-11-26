package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del personaje principal mejorado.
 */
public class Proyectil_Sanitario_Super extends Proyectil_Sanitario{
	protected final int poderDesinfeccionSuper = 20;
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del proyectil mejorado del jugador.
	 * @param movimiento Movimiento del proyectil del jugador.
	 */
	public Proyectil_Sanitario_Super(Movimiento movimiento) {
		super(movimiento);
		this.poder = poderDesinfeccionSuper;
		this.visitor = new VisitorProyectilSanitarioSuper(this);
		this.grafica = new EntidadGrafica_Proyectil_Sanitario_Super((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	/**
	 * Visita al proyectil del jugador mejorado.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}
