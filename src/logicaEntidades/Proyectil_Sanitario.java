package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela un proyectil del personaje principal.
 */
public class Proyectil_Sanitario extends Proyectil{
	
	/**
	 * Constructor del proyectil del jugador principal.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 * @param poder
	 */
	public Proyectil_Sanitario(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad,int poder) {
		super(movimiento,grafica,visitor,velocidad,poder);
	}
	
	/**
	 * Visita al proyectil del jugador.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visitProyectil_Sanitario(this);
	}
}
