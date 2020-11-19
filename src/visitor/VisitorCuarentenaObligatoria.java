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
 * Visitor del premio Cuarentena Obligatoria.
 */
public class VisitorCuarentenaObligatoria implements VisitorEntidad{
	private Cuarentena_Obligatoria co;
	
	/**
	 * Constructor del visitor.
	 * @param co Cuarentena obligatoria.
	 */
	public VisitorCuarentenaObligatoria(Cuarentena_Obligatoria co) {
		this.co = co;
	}

	@Override
	public void visit(Jugador j) {
		//Le digo al jugador que cambie de arma
		//Pasa el tiempo que dice co.
		//Le devuelvo al jugador su arma anterior.
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
