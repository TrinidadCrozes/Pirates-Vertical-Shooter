package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela un proyectil del personaje principal mejorado.
 */
public class Proyectil_Sanitario_Super extends Proyectil{
	
	/**
	 * Constructor del proyectil mejorado del jugador principal.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 * @param poder
	 */
	public Proyectil_Sanitario_Super(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad,int poder) {
		super(movimiento,grafica,visitor,velocidad,poder);
	}
	
	/**
	 * Visita al proyectil del jugador mejorado.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visitProyectil_Sanitario_Super(this);
	}
}
