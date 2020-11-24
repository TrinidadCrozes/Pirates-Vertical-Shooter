
package Fabrica;

import java.awt.Point;
import java.util.Random;

import logicaEntidades.Infectado;
import logicaEntidades.Infectado_Alpha;
import logicaJuego.Juego;
import movimientoEntidades.Movimiento_Enemigo;

/**
 * Clase que modela una fábrica de infectados Alpha.
 */
public class FabricaAlpha extends FabricaInfectado {
	protected Movimiento_Enemigo movimiento;
	
	/**
	 * Constructor de la fábrica.
	 * @param juego
	 */
	public FabricaAlpha(Juego juego) {
		super(juego);
	}

	@Override
	public Infectado crearInfectado(int anchoJFrame, int altoJFrame) {
		Point ubicacion = this.obtenerUbicacion(anchoJFrame);
		this.movimiento = new Movimiento_Enemigo(ubicacion.x, ubicacion.y, velocidad, altoJFrame);
		return new Infectado_Alpha(movimiento);
	}
	
}
