package movimientoEntidades;

import logicaEntidades.Proyectil;
import logicaEntidades.Proyectil_Sanitario;
import logicaEntidades.Proyectil_Sanitario_Super;
import logicaJuego.Juego;

/**
 * Clase que modela al movimiento del jugador.
 */
public class Movimiento_Jugador extends Movimiento{
	protected Juego juego;
	
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
	
	/**
	 * El jugador lanza un misil.
	 * @return Proyectil.
	 */
	public Proyectil atacar() {
		Movimiento m = new Movimiento_Proyectil_Jugador(this.posicion.x,this.posicion.y,this.velocidad + 1,this.alturaFrame);
		Proyectil_Sanitario ps;
		if(juego.getJugador().isArmaEspecial()) {
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
