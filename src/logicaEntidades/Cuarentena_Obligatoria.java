package logicaEntidades;

import visitor.VisitorEntidad;

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
	public Cuarentena_Obligatoria(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad) {
		super(movimiento,grafica,visitor,velocidad);
	}
	
	/**
	 * Visita al premio.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visitCuarentena_Obligatoria(this);
	}
}
