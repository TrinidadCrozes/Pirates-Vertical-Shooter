
package Fabrica;

import java.awt.Point;
import java.util.Random;

import logicaEntidades.Infectado;
import logicaJuego.Juego;

/**
 * Clase que modela una fábrica de infectados.
 */
public abstract class FabricaInfectado {
	protected Juego juego;
	protected final int velocidad = 1;
	
	/**
	 * Constructor de la fábrica.
	 * @param juego Juego.
	 */
	public FabricaInfectado(Juego juego) {
		this.juego = juego;
	}
	
	/**
	 * Crea un infectado.
	 * @param anchoJFrame Ancho del frame del juego.
	 * @param altoJFrame Alto del frame del juego.
	 * @return Infectado Nuevo infectado.
	 */
	public abstract Infectado crearInfectado(int anchoJFrame, int altoJFrame);
	
	/**
	 * Retorna la ubicacion inicial del infectado.
	 * @param anchoJFrame Ancho del frame del juego.
	 * @return ubicación del infectado.
	 */
	protected Point obtenerUbicacion(int anchoJFrame) {
		Random rnd = new Random(0);
		int pos_x = rnd.nextInt(anchoJFrame); 
		Point ubicacion = new Point(pos_x, 0);
		return ubicacion;
	}
		
}
