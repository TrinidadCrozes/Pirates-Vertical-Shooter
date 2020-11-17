package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela al personaje principal.
 *
 */
public class Jugador {
	private static Jugador jugador;
	
	/**
	 * Constructor del jugador.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 * @param proyectil
	 */
	private Jugador(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad,Proyectil proyectil) {
		super(movimiento,grafica,visitor,velocidad,proyectil);
	}
	
	/**
	 * Método que devuelve al jugador.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 * @param proyectil
	 * @return
	 */
	public static Jugador getJugador(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad,Proyectil proyectil) {
		if(jugador == null) {
			jugador = new Jugador(movimiento,grafica,visitor,velocidad,proyectil);
		}
		return jugador;
	}
	
	/**
	 * Visita al jugador.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visitJugador(this);
	}
}
