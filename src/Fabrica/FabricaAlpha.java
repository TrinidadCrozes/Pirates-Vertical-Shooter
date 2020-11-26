
package Fabrica;

import java.awt.Point;

import logicaEntidades.Infectado;
import logicaEntidades.Infectado_Alpha;
import logicaJuego.Juego;
import movimientoEntidades.Movimiento_Enemigo;

/**
 * Clase que modela una fábrica de infectados Alpha.
 */
public class FabricaAlpha extends FabricaInfectado {
	
	/**
	 * Constructor de la fábrica.
	 * @param juego
	 */
	public FabricaAlpha(Juego juego) {
		super(juego);
	}

	@Override
	public Infectado crearInfectado() {
		Point ubicacion = this.obtenerUbicacion();
		Movimiento_Enemigo movimiento = new Movimiento_Enemigo(ubicacion.x, ubicacion.y, velocidad, juego.getJFrameJuego().getHeight());
		return new Infectado_Alpha(movimiento);
	}
	
}
