package Fabrica;

import logicaEntidades.Infectado;
import logicaMapa.LogicaMapa;

public abstract class FabricaInfectado {
	protected Infectado infectado;
	protected LogicaMapa mapa;
	
	public FabricaInfectado (LogicaMapa mapa) {
		this.mapa = mapa;
	}
	
	public abstract Infectado crearInfectado();
	
	
	
	
}
