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
 * Visitor del proyectil mejorado del jugador.
 */
public class VisitorProyectilSanitarioSuper implements VisitorEntidad {
	private Proyectil_Sanitario_Super ps;
	
	/**
	 * Constructor del visitor.
	 * @param ps Proyectil sanitario super.
	 */
	public VisitorProyectilSanitarioSuper(Proyectil_Sanitario_Super ps) {
		this.ps = ps;
	}

	@Override
	public void visit(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Infectado_Alpha i) {
		i.quitarVida(ps.getPoder());
	}

	@Override
	public void visit(Infectado_Beta i) {
		i.quitarVida(ps.getPoder());
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
