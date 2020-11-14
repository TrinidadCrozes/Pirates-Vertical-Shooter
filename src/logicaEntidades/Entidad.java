package logicaEntidades;

public abstract class Entidad {
	protected Movimiento movimiento;
	protected EntidadGrafica grafica;
	protected VisitorEntidad visitor;
	
	public Entidad() {
		
	}

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
