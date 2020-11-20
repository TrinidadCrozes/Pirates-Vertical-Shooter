package logicaEntidades;

import visitor.VisitorEntidad;
import visitor.VisitorJugador;
import movimientoEntidades.*;



import graficaEntidades.*; 

/**
 * Clase que modela al personaje principal.
 *
 */
public class Jugador extends Personaje{
	private static Jugador jugador;
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	protected Juego juego;
	protected boolean armaEspecial;
	
	/**
	 * Constructor del jugador.
	 * @param movimiento Movimiento del jugador.
	 * @param proyectil Proyectil del jugador.
	 * @param juego Juego del cual forma parte el juego.
	 */
	private Jugador(Movimiento movimiento,Proyectil proyectil,Juego juego) {
		super(movimiento,proyectil); 
		this.visitor = new VisitorJugador(this);
		this.grafica = new EntidadGrafica_Jugador();
		this.juego = juego;
		this.armaEspecial = false;
	}
	
	/**
	 * Retorna el juego.
	 * @return juego.
	 */
	public Juego getJuego() {
		return this.juego;
	}
	
	/**
	 * Analiza si el arma especial se encuentra activa.
	 * @return True si el jugador tiene el arma mejorada, false en caso contrario.
	 */
	public boolean isArmaEspecial() {
		return this.armaEspecial;
	}
	
	/**
	 * Activa el arma mejorada.
	 */
	public void activarArmaEspecial() {
		this.armaEspecial = true;
	}
	
	/**
	 * Desactiva el arma mejorada.
	 */
	public void desactivarArmaEspecial() {
		this.armaEspecial = false;
	}
	
	/**
	 * Obtiene un jugador.
	 * @param movimiento Movimiento del jugador.
	 * @param proyectil Proyectil del jugador.
	 * @param juego Juego.
	 * @return Jugador.
	 */
	public static Jugador getJugador(Movimiento movimiento,Proyectil proyectil,Juego juego) {
		if(jugador == null) {
			jugador = new Jugador(movimiento,proyectil,juego);
		}
		return jugador;
	}
	
	/**
	 * Completa la cantidad indicada de vida.
	 * @param v Vida a rellenar.
	 */
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
