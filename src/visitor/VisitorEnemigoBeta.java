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
 * Visitor del enemigo Beta.
 */
public class VisitorEnemigoBeta implements VisitorEntidad{
	private Infectado_Beta ib;
	
	/**
	 * Constructor del visitor.
	 * @param ib Infectado beta.
	 */
	public VisitorEnemigoBeta(Infectado_Beta ib) {
		this.ib = ib;
	}

	@Override
	public void visit(Jugador j) {
		j.quitarVida(ib.getDamageFisico());
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
		ps.quitarVida(ps.getVida());
	}

	@Override
	public void visit(Proyectil_Sanitario ps) {
		ps.quitarVida(ps.getVida());
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
