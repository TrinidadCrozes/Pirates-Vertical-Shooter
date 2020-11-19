package movimientoEntidades;

/**
 * Clase que modela al movimiento de un enemigo.
 */
public class Movimiento_Enemigo extends Movimiento {
	
	/**
	 * Constructor del movimiento de un enemigo, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 */
	public Movimiento_Enemigo(int x, int y,int velocidad) {
		super(x, y, velocidad);
	}

	@Override
	public void desplazar() {
		this.posicion.setLocation(this.posicion.x,this.posicion.y + velocidad);
	}

	@Override
	public void moverDerecha() {
		//No se mueve hacia la derecha.
	}

	@Override
	public void moverIzquierda() {
		//No se mueve hacia la izquierda.
	}

}
