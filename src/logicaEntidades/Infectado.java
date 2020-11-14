package logicaEntidades;

public abstract class Infectado {

	public Infectado() {
		Proyectil p = new Proyectil_Infectado();
		super(0,p);
	}
}
