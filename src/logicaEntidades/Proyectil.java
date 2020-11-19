package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil.
 */
public abstract class Proyectil extends Entidad {
	protected int poder;
	protected boolean colisiono = false;
	
	/**
	 * Constructor del proyectil.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 */
	public Proyectil(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}
	
	public boolean Colisiono() {
		return colisiono;
	}

	public void haColisionado() {
		this.colisiono = true;
	}
	
}
