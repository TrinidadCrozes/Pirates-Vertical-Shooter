package logicaEntidades;

import visitor.VisitorEntidad;

/**
 * Clase que modela el tipo de premio objeto precioso.
 */
public abstract class Objeto_Precioso extends Premio{

	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 * @param velocidad
	 */
	public Objeto_Precioso(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor,int velocidad) {
		super(movimiento,grafica,visitor,velocidad);
	}
}
