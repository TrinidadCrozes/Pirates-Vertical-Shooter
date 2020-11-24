package logicaJuego;

public abstract class Nivel {
	
	protected int cantidadEnemigos;
	protected int cantidadEnemigosAlpha;
	protected int cantidadEnemigosBeta;
	protected Nivel siguienteNivel;
	
	protected Nivel(int cantEnemigos) {
		
		this.cantidadEnemigos = cantEnemigos;
		this.cantidadEnemigosAlpha = cantEnemigos/2;
		this.cantidadEnemigosBeta = cantEnemigos/2;

	}
	
	/**
	 * Retorna el nivel siguiente.
	 * @return
	 */
	protected abstract Nivel getSiguienteNivel();
	
	protected int getListaEnemigos() {
		return this.cantidadEnemigos;
	}

	protected int getCantidadEnemigosAlpha() {
		return this.cantidadEnemigosAlpha;
	}

	protected int getCantidadEnemigosBeta() {
		return this.cantidadEnemigosBeta;
	}
	
	protected int getPrimeraCantidadEnemigos() {
		return this.cantidadEnemigos/2;
	}
	
	protected int getSegundaCantidadEnemigos() {
		return this.cantidadEnemigos/2;
	}

}
