package visitor;

import logicaEntidades.Cuarentena_Obligatoria;

import logicaEntidades.Infectado_Alpha;
import logicaEntidades.Infectado_Beta;
import logicaEntidades.Jugador;
import logicaEntidades.Pocion;
import logicaEntidades.Proyectil_Infectado;
import logicaEntidades.Proyectil_Sanitario;
import logicaEntidades.Proyectil_Sanitario_Super;
import logicaEntidades.Super_Arma_Sanitaria;

/**
 * Visitor del premio super arma sanitaria.
 */
public class VisitorSuperArmaSanitaria implements VisitorEntidad {
	private Super_Arma_Sanitaria sa;
	
	/**
	 * Constructor del visitor.
	 * @param sa Super arma sanitaria.
	 */
	public VisitorSuperArmaSanitaria(Super_Arma_Sanitaria sa) {
		this.sa = sa;
	}

	@Override
	public void visit(Jugador j) {
		j.getJuego().cambiarArmaJugador(sa.getDuracion());
	}

	@Override
	public void visit(Infectado_Alpha i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Infectado_Beta i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Proyectil_Sanitario_Super ps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Proyectil_Sanitario ps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Proyectil_Infectado pi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Pocion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Cuarentena_Obligatoria co) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Super_Arma_Sanitaria sa) {
		// TODO Auto-generated method stub
		
	}
}

