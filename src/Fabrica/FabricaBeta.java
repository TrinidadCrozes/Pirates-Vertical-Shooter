
package Fabrica;

import java.awt.Point;
import java.util.Random;

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
	public Infectado crearInfectado(int anchoJFrame, int altoJFrame) {
		Point ubicacion = this.obtenerUbicacion(anchoJFrame);
		Movimiento_Enemigo movimiento = new Movimiento_Enemigo(ubicacion.x, ubicacion.y, velocidad, altoJFrame);
		return new Infectado_Beta(movimiento);
	}
	
}
