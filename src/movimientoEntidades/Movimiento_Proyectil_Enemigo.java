package movimientoEntidades;

import logicaEntidades.Premio;
import logicaEntidades.Proyectil;

/**
 * Clase que modela el movimiento de los proyectiles del enemigo.
 */
public class Movimiento_Proyectil_Enemigo extends Movimiento{
	protected final int cantidadDesplazamientosMax = 50;
	protected int cantidadDesplazamientos;
	protected final int movimientoProyectilEnemigo = 4;
	
	/**
	 * Constructor del movimiento de un proyectil, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Proyectil_Enemigo(int x, int y,  int alturaFrame) {
		super(x, y, alturaFrame);
		cantidadDesplazamientos = 0;
		this.setVelocidad(movimientoProyectilEnemigo);
	}
	
	@Override
	public boolean puedeMoverse() {
		return !(cantidadDesplazamientos >= cantidadDesplazamientosMax);
	}

	@Override
	public void desplazar() {
		this.posicion.setLocation((int)this.posicion.getX(),(int)this.posicion.getY() + velocidad);
		cantidadDesplazamientos++;
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
	public Proyectil atacar() {
		return null;
	}

	@Override
	public Premio lanzarPremio() {
		return null;
	}

}
 
