package logicaEntidades;

import visitor.VisitorEntidad;
import movimientoEntidades.*;
import graficaEntidades.*; 

/**
 * Clase que modela al personaje principal.
 *
 */
public class Jugador extends Personaje{
	private static Jugador jugador;
	
	/**
	 * Constructor del jugador.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param proyectil
	 */
	private Jugador(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,Proyectil proyectil) {
		super(movimiento,grafica,visitor,proyectil); 
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
			jugador = new Jugador(movimiento,grafica,visitor,proyectil);
		}
		return jugador;
	}
	
	public void rellenarVida(int v) {
		this.vida = this.vida + v;
		if(this.vida > this.vidaMax) {
			this.vida = this.vidaMax;
		}
	}
	
	/**
	 * Visita al jugador.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}
