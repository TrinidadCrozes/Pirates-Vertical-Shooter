package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela la poción.
 */
public class Pocion extends Objeto_Precioso{
	protected final int vida = 40;
	protected EntidadGrafica grafica;
	
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
		v.visit((Pocion)this);
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		return this.grafica;
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
