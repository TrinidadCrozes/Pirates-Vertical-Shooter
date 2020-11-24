package logicaJuego;

public class Nivel2 extends Nivel {

	public Nivel2() {
		
		super(30);
		this.siguienteNivel = null;
		
	}

	@Override
	protected Nivel getSiguienteNivel() {
		return this.siguienteNivel;
	}

}
