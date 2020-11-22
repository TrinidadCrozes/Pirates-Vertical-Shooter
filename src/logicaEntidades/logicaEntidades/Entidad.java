package logicaEntidades; 
import visitor.*;
import graficaEntidades.EntidadGrafica;
import movimientoEntidades.*;

/**
 * Clase que modela una entidad.
 */
public abstract class Entidad {
	protected Movimiento movimiento;
	
	/**
	 * Crea una entidad.
	 * @param movimiento Movimiento del personaje.
	 */
	public Entidad(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
	/**
	 * Visitor de la entidad.
	 * @param v Visitor.
	 */
	public abstract void visitar(VisitorEntidad v);

	/**
	 * Retorna el movimiento de la entidad.
	 * @return movimiento.
	 */
	public Movimiento getMovimiento() {
		return movimiento;
	}
	
	/**
	 * Obtiene el movimiento de la entidad.
	 * @param movimiento.
	 */
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
	public abstract EntidadGrafica getEntidadGrafica();
	
}
