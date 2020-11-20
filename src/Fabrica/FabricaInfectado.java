package Fabrica;

import logicaEntidades.Infectado;
import logicaJuego.Juego;

public abstract class FabricaInfectado {
	protected Juego juego;
	
	public FabricaInfectado(Juego juego) {
		this.juego = juego;
	}
	
	public abstract Infectado crearInfectado();
	
	
	
	
	
}
