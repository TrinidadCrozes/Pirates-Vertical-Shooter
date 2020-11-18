package logicaEntidades;

import logicaEntidades.Movimiento.Movimiento;
import visitor.VisitorEntidad;

public class Infectado_Alpha extends Infectado{

	public Infectado_Alpha(Movimiento movimiento, EntidadGrafica grafica, VisitorEntidad visitor, int velocidad, Proyectil proyectil) {
		super(movimiento, grafica, visitor, velocidad, proyectil);
	
	}

	@Override
	public void visitar(VisitorEntidad v) {
		// TODO Auto-generated method stub
		
	}

}
