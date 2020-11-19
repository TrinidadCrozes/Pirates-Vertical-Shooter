package logicaEntidades;

import visitor.*;

import movimientoEntidades.*;
import graficaEntidades.*;

/**
 * Clase que modela un premio.
 */
public abstract class Premio extends Entidad {
	protected boolean colisiono = false;
	
	/**
	 * Constructor del premio.
	 * @param movimiento
	 * @param grafica
	 * @param visitor
	 */
	public Premio(Movimiento movimiento,EntidadGrafica grafica,VisitorEntidad visitor) {
		super(movimiento,grafica,visitor);
	}

	public boolean Colisiono() {
		return colisiono;
	}

	public void haColisionado() {
		this.colisiono = true;
	}
	
}
