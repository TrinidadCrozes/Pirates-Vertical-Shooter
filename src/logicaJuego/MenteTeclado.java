package logicaJuego;

import java.awt.event.KeyEvent;

import logicaEntidades.Entidad;
import logicaEntidades.Jugador;
import movimientoEntidades.Movimiento;

/**
 * Clase que modela el movimiento por teclado del jugador.
 */
public class MenteTeclado {
	private Juego juego;
	private final int esperarDisparo = 5;
	
	/**
	 * Constructor del movimiento.
	 * @param j Juego.
	 */
	public MenteTeclado(Juego j) {
		this.juego = j;
	}
	
	/**
	 * Mueve al jugador.
	 * @param key Tecla apretada.
	 */
	public void mover(int key) {
		Entidad proyectil;
		Jugador j = juego.getJugador();
		Movimiento mov_jugador = j.getMovimiento();
		
		switch(key) {
			case KeyEvent.VK_A: {
					mov_jugador.moverIzquierda();
				break;
			}
			case KeyEvent.VK_D: {
					mov_jugador.moverDerecha();
				break;
			}
			case KeyEvent.VK_SPACE: {
				if(juego.getEsperar_disparo() <= 0) {
					juego.setEsperar_disparo(esperarDisparo);
					proyectil = mov_jugador.atacar();
					juego.getEntidades().add(proyectil);
					juego.getJFrameJuego().agregarEntidad(proyectil);
				}
				break;
			}
		}
		
		j.getEntidadGrafica().getJLabel().setLocation(j.getMovimiento().getPosicion());
		
	}
}
