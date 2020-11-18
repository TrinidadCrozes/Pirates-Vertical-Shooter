package visitor;

import logicaEntidades.*;

public interface VisitorEntidad {

	public void visitarInfectado_Alpha(Infectado_Alpha e);
	public void visitarInfectado_Beta(Infectado_Beta e);
	public void visitProyectil_Infectado(Proyectil_Infectado proyectil_Infectado);
	public void visitJugador(Jugador jugador);
	
	
	//Faltan visitors, premios, proyectiles, etc
	
}
