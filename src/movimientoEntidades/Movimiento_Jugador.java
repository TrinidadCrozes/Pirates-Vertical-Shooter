package movimientoEntidades;

import logicaJuego.Juego;
import logicaEntidades.Premio;
import logicaEntidades.Proyectil;
import logicaEntidades.Proyectil_Sanitario;
import logicaEntidades.Proyectil_Sanitario_Super;

/**
 * Clase que modela al movimiento del jugador.
 */
public class Movimiento_Jugador extends Movimiento{
	protected Juego juego;
	protected final int velocidadJugador = 2;
	
	/**
	 * Constructor del movimiento del jugador, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 * @param juego Juego.
	 */
	public Movimiento_Jugador(int x, int y, int alturaFrame,Juego juego) {
		super(x, y, alturaFrame);
		this.juego = juego;
		this.setVelocidad(velocidadJugador);
	}
	
	/**
	 * El jugador lanza un misil.
	 * @return Proyectil.
	 */
	public Proyectil atacar() {
		Movimiento m = new Movimiento_Proyectil_Jugador((int)this.posicion.getX(),(int)this.posicion.getY(),this.alturaFrame);
		Proyectil_Sanitario ps;
		
		if(!juego.getJugador().isArmaEspecial()) {
			ps = new Proyectil_Sanitario(m);
		}else {
			ps = new Proyectil_Sanitario_Super(m);
		}
		return ps;
	}

	@Override
	public void desplazar() {
		//No usa el metodo desplazar.
	}

	@Override
	public void moverDerecha() {
		if((int)this.posicion.getX() < juego.getJFrameJuego().getWidth())
			this.posicion.setLocation((int)this.posicion.getX() + this.getVelocidad(),(int)this.posicion.getY());
	}

	@Override
	public void moverIzquierda() {
		if((int)this.posicion.getX() > 0)
			this.posicion.setLocation((int)this.posicion.getX() - this.getVelocidad(),(int)this.posicion.getY());
	}

	@Override
	public boolean puedeMoverse() {
		return true;
	}

	@Override
	public Premio lanzarPremio() {
		return null;
	}

}
