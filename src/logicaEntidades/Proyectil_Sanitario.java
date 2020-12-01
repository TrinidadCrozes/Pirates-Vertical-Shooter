package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un proyectil del personaje principal.
 */
public class Proyectil_Sanitario extends Proyectil{
	protected final int poderDesinfeccion = 10;
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del proyectil del jugador.
	 * @param movimiento Movimiento del proyectil del jugador.
	 */
	public Proyectil_Sanitario(Movimiento movimiento) {
		super(movimiento);
		this.poder = poderDesinfeccion;
		this.visitor = new VisitorProyectilSanitario(this);
		this.grafica = new EntidadGrafica_Proyectil_Sanitario((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	/**
	 * Visita al proyectil del jugador.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit((Proyectil_Sanitario)this);
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
