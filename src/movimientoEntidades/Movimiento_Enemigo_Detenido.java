package movimientoEntidades;

/**
 * Modela el movimiento de un enemigo detenido.
 */
public class Movimiento_Enemigo_Detenido extends Movimiento_Enemigo {
	
	/**
	 * Constructor del movimiento de un enemigo, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Enemigo_Detenido(int x, int y, int alturaFrame) {
		super(x, y, alturaFrame);
	}
	
	@Override
	public void desplazar() {
		//No se desplaza.
	}

}
