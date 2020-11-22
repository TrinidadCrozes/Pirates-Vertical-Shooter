package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del personaje principal.
 */
public class Proyectil_Sanitario extends Proyectil{
	protected final int poderDesinfeccion = 10;
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del proyectil del jugador.
	 * @param movimiento Movimiento del proyectil del jugador.
	 */
	public Proyectil_Sanitario(Movimiento movimiento) {
		super(movimiento);
		this.poder = poderDesinfeccion;
		this.visitor = new VisitorProyectilSanitario(this);
		this.grafica = new EntidadGrafica_Proyectil_Sanitario();
	}
	
	/**
	 * Visita al proyectil del jugador.
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

