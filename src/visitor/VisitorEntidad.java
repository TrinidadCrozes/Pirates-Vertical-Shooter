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
	public abstract void visitJugador(Jugador j);
	
	/**
	 * Visita al infectado Alpha.
	 * @param i Infectado Alpha.
	 */
	public abstract void visitInfectado_Alpha(Infectado_Alpha i);
	
	/**
	 * Visita al infectado Beta.
	 * @param i Infectado Beta.
	 */
	public abstract void visitInfectado_Beta(Infectado_Beta i);
	
	/**
	 * Visita al proyectil sanitario.
	 * @param ps Proyectil sanitario.
	 */
	public abstract void visitProyectil_Sanitario(Proyectil_Sanitario ps);
	
	/**
	 * Visita al proyectil sanitario mejorado.
	 * @param ps Proyectil sanitario super.
	 */
	public abstract void visitProyectil_Sanitario_Super(Proyectil_Sanitario_Super ps);
	
	/**
	 * Visita al proyectil infectado.
	 * @param pi Proyectil infectado.
	 */
	public abstract void visitProyectil_Infectado(Proyectil_Infectado pi);
	
	/**
	 * Visita el premio poción.
	 * @param p Poción.
	 */
	public abstract void visitPocion(Pocion p);
	
	/**
	 * Visita el premio cuarentena obligatoria.
	 * @param co Cuarentena obligatoria.
	 */
	public abstract void visitCuarentena_Obligatoria(Cuarentena_Obligatoria co);
	
	/**
	 * Visita al premio súper arma sanitaria. 
	 * @param sa Arma sanitaria.
	 */
	public abstract void visitSuper_Arma_Sanitaria(Super_Arma_Sanitaria sa);
}
