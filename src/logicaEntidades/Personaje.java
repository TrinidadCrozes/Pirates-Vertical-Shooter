package logicaEntidades;

import visitor.*;

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
	 * @param velocidad
	 * @param proyectil
	 */
	public Personaje(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad,Proyectil proyectil) {
		super(movimiento,grafica,visitor);
		this.proyectil = proyectil;
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

	public void setVida(int vida) {
		this.vida = vida;
	}
}
