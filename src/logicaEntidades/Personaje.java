package logicaEntidades;

public abstract class Personaje extends Entidad {
	protected int cargaViral;
	protected Proyectil proyectil;
	
	public Personaje(int cargaViral,Proyectil proyectil) {
		super();
		this.cargaViral = cargaViral;
		this.proyectil = proyectil;
	}

	public int getCargaViral() {
		return cargaViral;
	}

	public void setCargaViral(int cargaViral) {
		this.cargaViral = cargaViral;
	}
	
}
