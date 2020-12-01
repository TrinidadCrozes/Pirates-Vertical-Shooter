package movimientoEntidades;

/**
 * Clase que modela al movimiento de un enemigo.
 */
public class Movimiento_Enemigo_Mejorado extends Movimiento_Enemigo {
	protected final double extra = 2;
	
	/**
	 * Constructor del movimiento de un enemigo, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Enemigo_Mejorado(int x, int y,int velocidad,int alturaFrame) {
		super(x, y, velocidad, alturaFrame);
	}
	
} 
