package visitor;

import logicaEntidades.*;

/**
 * Visitor de las entidades.
 */
public interface VisitorEntidad {

	/**
	 * Visita al jugador.
	 * @param j Jugador.
	 */
	public abstract void visit(Jugador j);
	
	/**
	 * Visita al infectado Alpha.
	 * @param i Infectado Alpha.
	 */
	public abstract void visit(Infectado_Alpha i);
	
	/**
	 * Visita al infectado Beta.
	 * @param i Infectado Beta.
	 */
	public abstract void visit(Infectado_Beta i);
	
	/**
	 * Visita al proyectil sanitario mejorado.
	 * @param ps Proyectil sanitario super.
	 */
	public abstract void visit(Proyectil_Sanitario_Super ps);
	
	/**
	 * Visita al proyectil sanitario.
	 * @param ps Proyectil sanitario.
	 */
	public abstract void visit(Proyectil_Sanitario ps);
	
	/**
	 * Visita al proyectil infectado.
	 * @param pi Proyectil infectado.
	 */
	public abstract void visit(Proyectil_Infectado pi);
	
	/**
	 * Visita el premio poción.
	 * @param p Poción.
	 */
	public abstract void visit(Pocion p);
	
	/**
	 * Visita el premio cuarentena obligatoria.
	 * @param co Cuarentena obligatoria.
	 */
	public abstract void visit(Cuarentena_Obligatoria co);
	
	/**
	 * Visita al premio súper arma sanitaria. 
	 * @param sa Arma sanitaria.
	 */
	public abstract void visit(Super_Arma_Sanitaria sa);
}