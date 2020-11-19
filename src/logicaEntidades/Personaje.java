package logicaEntidades;

import visitor.*;
import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un personaje.
 */
public abstract class Personaje extends Entidad {
	protected Proyectil proyectil;
	protected int vida;
	protected final int vidaMax = 100;

	/**
	 * Constructor del personaje.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param proyectil
	 */
	public Personaje(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,Proyectil proyectil) {
		super(movimiento,grafica,visitor);
		this.proyectil = proyectil;
		this.vida = this.vidaMax;
	}

	public Proyectil getProyectil() {
		return proyectil;
	}

	public void setProyectil(Proyectil proyectil) {
		this.proyectil = proyectil;
	}

	public int getVida() {
		return vida;
	}
	
	public int getVidaMax() {
		return vidaMax;
	}

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
