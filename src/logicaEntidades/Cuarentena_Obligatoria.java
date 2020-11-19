package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela al premio cuarentena obligatoria.
 */
public class Cuarentena_Obligatoria extends Efecto_Temporal {

	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 */
	public Cuarentena_Obligatoria(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
	}
	
	/**
	 * Visita al premio.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit(this);
	}
}

