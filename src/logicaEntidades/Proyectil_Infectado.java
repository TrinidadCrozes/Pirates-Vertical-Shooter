package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del enemigo.
 */
public class Proyectil_Infectado extends Proyectil{
	protected final int poderInfeccion = 10;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del proyectil infectado.
	 * @param movimiento Movimiento del proyectil infectado.
	 */
	public Proyectil_Infectado(Movimiento movimiento) {
		super(movimiento);
		this.poder = poderInfeccion;
		this.visitor = new VisitorProyectilEnemigo(this);
		this.grafica = new EntidadGrafica_Proyectil_Infectado((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	/**
	 * Visita al proyectil del enemigo.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit((Proyectil_Infectado)this);
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
	public boolean estaVivo() {
		return vida > 0 && this.movimiento.puedeMoverse();
	}
	
	@Override
	public void setEntidadGrafica(EntidadGrafica g) {
		this.grafica = g;
	}
}