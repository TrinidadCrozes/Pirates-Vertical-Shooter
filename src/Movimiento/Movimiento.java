package movimientoEntidades;

import java.awt.Point;

/**
 * Clase que modela al movimiento de una entidad.
 */
public abstract class Movimiento {
	protected Point posicion;
	
	/**
	 * Constructor del movimiento de una entidad, se inicializa con la posición inicial de la misma.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 */
	public Movimiento(int x,int y) {
		posicion = new Point(x,y);
	}
	
	/**
	 * Desplaza la entidad hacia arriba.
	 */
	public abstract void moverArriba();

	/**
	 * Desplaza la entidad hacia abajo.
	 */
	public abstract void moverAbajo();

	/**
	 * Desplaza la entidad hacia la derecha.
	 */
	public abstract void moverDerecha();

	/**
	 * Desplaza la entidad hacia la izquierda.
	 */
	public abstract void moverIzquierda();
}
