package movimientoEntidades;

/**
 * Clase que modela el movimiento de los proyectiles del jugador.
 */
public class Movimiento_Proyectil_Jugador extends Movimiento{

	/**
	 * Constructor del movimiento de un proyectil, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Proyectil_Jugador(int x, int y, int velocidad, int alturaFrame) {
		super(x, y, velocidad, alturaFrame);
	}

	@Override
	public void desplazar() {
		this.posicion.setLocation(this.posicion.x,this.posicion.y - velocidad);
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
		return !(this.posicion.y == 0);
	}

}

