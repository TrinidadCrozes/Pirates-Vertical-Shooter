package logicaEntidades;

package logicaEntidades;
import visitor.*;

/**
 * Clase que modela una entidad.
 */
public abstract class Entidad {
	protected Movimiento movimiento;
	protected EntidadGrafica grafica;
	protected VisitorEntidad visitor;
	protected int velocidad;
	
	/**
	 * Constructor de la entidad.
	 */
	public Entidad(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad) {
		this.movimiento = movimiento;
		this.grafica = grafica;
		this.visitor = visitor;
		this.velocidad = velocidad;
	}
	
	/**
	 * Visitor de la entidad.
	 * @param v Visitor.
	 */
	public abstract void visitar(VisitorEntidad v);

	
	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public EntidadGrafica getGrafica() {
		return grafica;
	}

	public void setGrafica(EntidadGrafica grafica) {
		this.grafica = grafica;
	}

	public VisitorEntidad getVisitor() {
		return visitor;
	}

	public void setVisitor(VisitorEntidad visitor) {
		this.visitor = visitor;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}	
}
