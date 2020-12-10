package movimientoEntidades;

import java.awt.Point;

import logicaEntidades.Premio;
import logicaEntidades.Proyectil;

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
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento(int x,int y,int alturaFrame) {
		posicion = new Point(x,y);
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
	 * Obtiene la velocidad de la entidad.
	 * @return Velocidad.
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Retorna la altura del frame.
	 * @return Altura del frame.
	 */
	public int getAlturaFrame() {
		return alturaFrame;
	}

	/**
	 * Modifica la velocidad de la entidad por la pasada como parámetro.
	 * @param velocidad Velocidad.
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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
	 * Ataca.
	 * @return Proyectil que lanza.
	 */
	public abstract Proyectil atacar();
	
	/**
	 * Tira un premio.
	 * @return Premio.
	 */
	public abstract Premio lanzarPremio();
}
