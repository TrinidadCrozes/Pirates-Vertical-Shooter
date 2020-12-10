package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela la poción.
 */
public class Pocion extends Objeto_Precioso{
	protected final int vida = 40;
	
	/**
	 * Constructor de la poción.
	 * @param movimiento Movimiento de la poción.
	 */
	public Pocion(Movimiento movimiento) {
		super(movimiento);
		this.visitor = new VisitorPocion(this);
		this.grafica = new EntidadGrafica_Pocion((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	/**
	 * Retorna la vida que suma consumir la poción.
	 * @return Vida.
	 */
	public int getVidaSumar() {
		return vida;
	}
	
	/**
	 * Visita a la pocion.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
	
}
