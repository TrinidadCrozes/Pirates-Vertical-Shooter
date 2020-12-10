
package Fabrica;

import java.awt.Point;


import logicaEntidades.Infectado;
import logicaEntidades.Infectado_Beta;
import logicaJuego.Juego;
import movimientoEntidades.Movimiento_Enemigo;

/**
 * Clase que modela una fábrica de infectados Beta.
 */
public class FabricaBeta extends FabricaInfectado {
	
	/**
	 * Constructor de la fábrica.
	 * @param juego
	 */
	public FabricaBeta(Juego juego) {
		super(juego);
	}

	@Override
	public Infectado crearInfectado() {
		Point ubicacion = this.obtenerUbicacion();
		Movimiento_Enemigo movimiento = new Movimiento_Enemigo((int)ubicacion.getX(),(int)ubicacion.getY(), juego.getJFrameJuego().getHeight());
		return new Infectado_Beta(movimiento,juego);
	}
	
}