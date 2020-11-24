package logicaJuego;

public class Nivel1 extends Nivel {

	public Nivel1() {
		
		super(20);
		this.siguienteNivel = new Nivel2();
		
	}

	@Override
	protected Nivel getSiguienteNivel() {
		return this.siguienteNivel;
	}
	
}
