package movimientoEntidades;

/**
 * Clase que modela al movimiento mejorado de un enemigo.
 */
public class Movimiento_Enemigo_Mejorado extends Movimiento_Enemigo {
	protected final double extra = 2;
	
	/**
	 * Constructor del movimiento de un enemigo, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Enemigo_Mejorado(int x, int y,int alturaFrame) {
		super(x, y, alturaFrame);
	}

	@Override
	public void desplazar() {
		this.posicion.setLocation((int)this.posicion.getX(),(int)this.posicion.getY() + super.getVelocidadEnemigo()*extra);
		if((int)this.posicion.getY() >= alturaFrame) {
			this.posicion.setLocation((int)this.posicion.getX(),0);
		}
	}
}
