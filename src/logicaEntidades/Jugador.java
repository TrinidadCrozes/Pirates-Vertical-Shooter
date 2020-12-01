package logicaEntidades;

import visitor.VisitorEntidad;
import visitor.VisitorJugador;
import movimientoEntidades.*;



import graficaEntidades.*;
import logicaJuego.Juego; 

/**
 * Clase que modela al personaje principal.
 *
 */
public class Jugador extends Personaje{
	private static Jugador jugador = null;
	protected EntidadGrafica grafica;
	protected Juego juego;
	protected boolean armaEspecial;
	
	/**
	 * Constructor del jugador.
	 * @param movimiento Movimiento del jugador.
	 * @param juego Juego del cual forma parte el juego.
	 */
	private Jugador(Movimiento movimiento,Juego juego) {
		super(movimiento); 
		this.visitor = new VisitorJugador(this);
		this.grafica = new EntidadGrafica_Jugador((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
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
	 * @param juego Juego.
	 * @return Jugador.
	 */
	public static Jugador getJugador(Movimiento movimiento,Juego juego) {
		if(jugador == null) {
			jugador = new Jugador(movimiento,juego);
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
		v.visit((Jugador)this);
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		return grafica;
	}

	@Override
	public boolean estadoCritico() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void setEntidadGrafica(EntidadGrafica g) {
		this.grafica = g;
	}
}
