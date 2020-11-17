package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela un proyectil del enemigo.
 */
public class Proyectil_Infectado extends Proyectil{
	
	/**
	 * Constructor del proyectil del enemigo.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 * @param poder
	 */
	public Proyectil_Infectado(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad,int poder) {
		super(movimiento,grafica,visitor,velocidad,poder);
	}
	
	/**
	 * Visita al proyectil del enemigo.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visitProyectil_Infectado(this);
	}
}
