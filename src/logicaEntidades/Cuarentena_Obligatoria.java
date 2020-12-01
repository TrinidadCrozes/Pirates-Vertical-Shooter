package logicaEntidades;

import visitor.*;
import graficaEntidades.EntidadGrafica;
import graficaEntidades.EntidadGrafica_CuarentenaObligatoria;
import movimientoEntidades.*;

/**
 * Clase que modela al premio cuarentena obligatoria.
 */
public class Cuarentena_Obligatoria extends Efecto_Temporal {
	protected EntidadGrafica grafica;
	
	/**
	 * Constructor del premio cuarentena obligatoria. 
	 * @param movimiento Movimiento del premio.
	 */
	public Cuarentena_Obligatoria(Movimiento movimiento) {
		super(movimiento);
		this.visitor = new VisitorCuarentenaObligatoria(this);
		this.grafica = new EntidadGrafica_CuarentenaObligatoria((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY());
	}
	
	/**
	 * Visita al premio.
	 * @param v Visitor.
	 */
	public void visitar(VisitorEntidad v) {
		v.visit((Cuarentena_Obligatoria)this);
	}

	@Override
	public EntidadGrafica getEntidadGrafica() {
		return grafica;
	}

	@Override
	public boolean estadoCritico() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEntidadGrafica(EntidadGrafica g) {
		this.grafica = g;
	}
}
