package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela un proyectil.
 */
public abstract class Proyectil extends Entidad {
	protected int poder;
	
	/**
	 * Constructor del proyectil.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 * @param poder
	 */
	public Proyectil(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad,int poder) {
		super(movimiento,grafica,visitor,velocidad);
		this.poder = poder;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}
	
}
