package movimientoEntidades;

import logicaEntidades.Premio;
import logicaEntidades.Proyectil;

/**
 * Clase que modela el movimiento de los premios.
 */
public class Movimiento_Premio extends Movimiento{
	
	/**
	 * Constructor del movimiento de un premio, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Premio(int x, int y, int velocidad, int alturaFrame) {
		super(x, y,alturaFrame);
		this.setVelocidad(velocidad);
	}

	@Override
	public void desplazar() {
		this.posicion.setLocation((int)this.posicion.getX(),(int)this.posicion.getY() + velocidad);
	}

	@Override
	public void moverDerecha() {
		//No se mueve hacia la derecha.
	}

	@Override
	public void moverIzquierda() {
		//No se mueve hacia la izquierda.
	}

	@Override
	public boolean puedeMoverse() {
		return !((int)this.posicion.getY() == alturaFrame);
	}

	@Override
	public Proyectil atacar() {
		return null;
	}

	@Override
	public Premio lanzarPremio() {
		return null;
	}

}
