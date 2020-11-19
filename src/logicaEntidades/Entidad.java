package logicaEntidades;
import visitor.*;

/**
 * Clase que modela una entidad.
 */
public abstract class Entidad {
	protected Movimiento movimiento;
	protected EntidadGrafica grafica;
	protected VisitorEntidad visitor;
	
	/**
	 * Constructor de la entidad.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 */
	public Entidad(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		this.movimiento = movimiento;
		this.grafica = grafica;
		this.visitor = visitor;
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
}
