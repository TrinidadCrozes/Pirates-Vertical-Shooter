package logicaEntidades;

import logicaEntidades.Movimiento.Movimiento;
import visitor.VisitorEntidad;

//
public abstract class Infectado extends Personaje  Thread {

	public Infectado(Movimiento movimiento, EntidadGrafica grafica, VisitorEntidad visitor, int velocidad, Proyectil proyectil) {
		super(movimiento, grafica, visitor, velocidad, proyectil);
		
	}
	
	
	
}