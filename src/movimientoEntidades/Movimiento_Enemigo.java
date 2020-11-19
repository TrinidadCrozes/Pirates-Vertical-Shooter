package movimientoEntidades;

/**
 * Clase que modela al movimiento de un enemigo.
 */
public class Movimiento_Enemigo extends Movimiento {
	protected boolean detenido = false;
	
	/**
	 * Constructor del movimiento de un enemigo, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Enemigo(int x, int y,int velocidad,int alturaFrame) {
		super(x, y, velocidad, alturaFrame);
	}

	@Override
	public void desplazar() {
		if(!detenido) {
			this.posicion.setLocation(this.posicion.x,this.posicion.y + velocidad);
			if(this.posicion.y == alturaFrame) {
				this.posicion.setLocation(this.posicion.x,0);
			}
		}
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
		return !detenido;
	}
	
	public void detener() {
		detenido = true;
	}

	public void mover() {
		detenido = false;
	}
}
