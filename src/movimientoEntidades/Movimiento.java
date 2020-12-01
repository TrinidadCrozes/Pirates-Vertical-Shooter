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
	 * Constructor del movimiento de una entidad, se inicializa con la posición inicial de la misma.
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
	 * Devuelve la posición de la entidad.
	 * @return Posición de la entidad.
	 */
	public Point getPosicion() {
		return posicion;
	}
	
	/**
	 * Analiza si la entidad aún puede desplazarse o alcanzó algún tipo de límite.
	 * @return True si aún puede desplazarse, false en caso contrario.
	 */
	public abstract boolean puedeMoverse();
	
	/**
	 * Desplaza la entidad.
	 */
	public abstract void desplazar();

	/**
	 * Desplaza la entidad hacia la derecha.
	 */
	public abstract void moverDerecha();

	/**
	 * Desplaza la entidad hacia la izquierda.
	 */
	public abstract void moverIzquierda();
	
	/**
	 * Hace que la entidad ataque.
	 * @return Proyectil lanzado.
	 */
	public abstract Proyectil atacar();
	
	/**
	 * Hace que la entidad lance un premio. 
	 * @return Premio premio lanzado.
	 */
	public abstract Premio lanzarPremio();	
	
}
