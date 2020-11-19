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
 * Visitor del jugador.
 *
 */
public class VisitorJugador implements VisitorEntidad {

	@Override
	public void visit(Jugador j) {}

	@Override
	public void visit(Infectado_Alpha i) {}

	@Override
	public void visit(Infectado_Beta i) {}

	@Override
	public void visit(Proyectil_Sanitario ps) {}

	@Override
	public void visit(Proyectil_Sanitario_Super ps) {}

	@Override
	public void visit(Proyectil_Infectado pi) {
		pi.haColisionado();
	}

	@Override
	public void visit(Pocion p) {
		p.haColisionado();
	}

	@Override
	public void visit(Cuarentena_Obligatoria co) {
		co.haColisionado();
	}

	@Override
	public void visit(Super_Arma_Sanitaria sa) {
		sa.haColisionado();
	}
}
