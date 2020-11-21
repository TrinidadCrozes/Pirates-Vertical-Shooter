package logicaJuego;

public abstract class Nivel {

  protected int cantidadEnemigos;
	
	protected int getCantidadEnemigos() {
		return cantidadEnemigos;
	}

	protected abstract int getCantidadEnemigosAlpha();

	protected abstract int getCantidadEnemigosBeta();
  
}
