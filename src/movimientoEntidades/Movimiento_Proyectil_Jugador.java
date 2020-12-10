package movimientoEntidades;

import logicaEntidades.Premio;
import logicaEntidades.Proyectil;

/**
 * Clase que modela el movimiento de los proyectiles del jugador.
 */
public class Movimiento_Proyectil_Jugador extends Movimiento{
	protected final int velocidadProyectilJugador = 4;
	
	/**
	 * Constructor del movimiento de un proyectil, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Proyectil_Jugador(int x, int y, int alturaFrame) {
		super(x, y, alturaFrame);
		this.setVelocidad(velocidadProyectilJugador);
	}

	@Override
	public void desplazar() {
		this.posicion.setLocation((int)this.posicion.getX(),(int)this.posicion.getY() - velocidad);
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
		return !(this.posicion.y <= 0);
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

