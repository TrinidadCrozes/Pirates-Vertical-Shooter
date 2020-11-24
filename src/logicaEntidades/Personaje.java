package logicaEntidades;

import graficaEntidades.EntidadGrafica;
import movimientoEntidades.*;

/**
 * Clase que modela un personaje.
 */
public abstract class Personaje extends Entidad {
	protected int vida;
	protected final int vidaMax = 100;

	/**
	 * Constructor del personaje.
	 * @param movimiento Movimiento del personaje.
	 */
	public Personaje(Movimiento movimiento) {
		super(movimiento);
		this.vida = this.vidaMax;
	}
	
	/**
	 * Retorna la vida del personaje.
	 * @return Vida.
	 */
	public int getVida() {
		return vida;
	}
	
	/**
	 * Retorna la vida máxima del personaje.
	 * @return Vida máxima.
	 */
	public int getVidaMax() {
		return vidaMax;
	}
	
	/**
	 * Resta al personaje la vida indicada.
	 * @param v Vida a restar.
	 */
	public void quitarVida(int v) {
		this.vida = this.vida - v;
		if(this.vida < 0) {
			this.vida = 0;
		}
	}
	
	/**
	 * Analiza si el personaje está vivo.
	 * @return True si está vivo, false en caso contrario.
	 */
	public boolean estaVivo() {
		return vida != 0;
	}
	
}
