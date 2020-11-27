package movimientoEntidades;

import java.awt.Point;

import GUI.JFrameJuego;
import logicaEntidades.Entidad;
import logicaEntidades.Premio;
import logicaEntidades.Proyectil;
import logicaJuego.Juego;

/**
 * Clase que modela al movimiento de una entidad.
 */
public abstract class Movimiento {
	protected Point posicion;
	protected int velocidad,alturaFrame;
	
	/**
	 * Constructor del movimiento de una entidad, se inicializa con la posici�n inicial de la misma.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento(int x,int y,int velocidad,int alturaFrame) {
		posicion = new Point(x,y);
		this.velocidad = velocidad;
		this.alturaFrame = alturaFrame;
	}
	
	/**
	 * Devuelve la posici�n de la entidad.
	 * @return Posici�n de la entidad.
	 */
	public Point getPosicion() {
		return posicion;
	}
	
	/**
	 * Analiza si la entidad a�n puede desplazarse o alcanz� alg�n tipo de l�mite.
	 * @return True si a�n puede desplazarse, false en caso contrario.
	 */
	public abstract boolean puedeMoverse();
	
	/**
	 * Desplaza la entidad.
	 */
	public abstract void desplazar();

	/**
	 * Desplaza la entidad hacia la derecha.
	 * @param gui_juego 
	 */
	public abstract void moverDerecha();

	/**
	 * Desplaza la entidad hacia la izquierda.
	 */
	public abstract void moverIzquierda();
	
	public abstract Proyectil atacar();
	
	public abstract Premio lanzarPremio();

	/**
	 * Le indica a cada Entidad como atacar
	 * @param juego, no nulo
	 * @return Entidad que ataca
	 */
	public Entidad atacar(Juego juego) {
		return null;
	}

	public void moverDerecha(JFrameJuego gui_juego) {
		//no hace nada
	}
	
	
}
