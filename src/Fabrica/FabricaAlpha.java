package Fabrica;

import logicaEntidades.Infectado;
import logicaEntidades.Infectado_Alpha;
import logicaMapa.LogicaMapa;

public class FabricaAlpha extends FabricaInfectado {

	public FabricaAlpha(LogicaMapa mapa) {
		super(mapa);
	}

	@Override
	public Infectado crearInfectado() {
		return new Infectado_Alpha(null, null, null, null);
	}
	
	
	

}
