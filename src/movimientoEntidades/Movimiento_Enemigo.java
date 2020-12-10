package movimientoEntidades;

import Fabrica.Creador_Premio;
import logicaEntidades.Premio;
import logicaEntidades.Proyectil;
import logicaEntidades.Proyectil_Infectado;


/**
 * Clase que modela al movimiento de un enemigo.
 */
public class Movimiento_Enemigo extends Movimiento {
	protected final int velocidadEnemigo = 1;
	protected Creador_Premio cp = new Creador_Premio();
	
	/**
	 * Constructor del movimiento de un enemigo, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Enemigo(int x, int y,int alturaFrame) {
		super(x, y, alturaFrame);
		this.setVelocidad(velocidadEnemigo);
	}
	
	/**
	 * Crea un proyectil enemigo.
	 * @return proyectil enemigo.
	 */
	public Proyectil atacar() {
		Movimiento m = new Movimiento_Proyectil_Enemigo((int)this.posicion.getX(),(int)this.posicion.getY(),this.alturaFrame);
		Proyectil_Infectado p = new Proyectil_Infectado(m);
		return p;
	}
	
	/**
	 * Lanza un premio.
	 * @return premio.
	 */
	public Premio lanzarPremio() {
		return cp.getPremioRandom((int)this.getPosicion().getX(),(int)this.getPosicion().getY(),this.alturaFrame);
	}
	
	@Override
	public void desplazar() {
		this.posicion.setLocation((int)this.posicion.getX(),(int)this.posicion.getY() + velocidad);
		if((int)this.posicion.getY() >= alturaFrame) {
			this.posicion.setLocation((int)this.posicion.getX(),0);
		}
	}

	/**
	 * Retorna la velocidad del enemigo.
	 * @return Velocidad del enemigo.
	 */
	protected int getVelocidadEnemigo() {
		return this.velocidadEnemigo;
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
		return true;
	}

}

