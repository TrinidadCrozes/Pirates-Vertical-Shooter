package movimientoEntidades;

/**
 * Clase que modela al movimiento del jugador.
 */
public class Movimiento_Jugador extends Movimiento{

	/**
	 * Constructor del movimiento del jugador, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Jugador(int x, int y, int velocidad, int alturaFrame) {
		super(x, y, velocidad, alturaFrame);
	}

	@Override
	public void desplazar() {
		//No usa el metodo desplazar.
	}

	@Override
	public void moverDerecha() {
		this.posicion.setLocation(this.posicion.x + velocidad,this.posicion.y);
	}

	@Override
	public void moverIzquierda() {
		this.posicion.setLocation(this.posicion.x - velocidad,this.posicion.y);
	}
	
	@Override
	public boolean puedeMoverse() {
		return true;
	}

}

