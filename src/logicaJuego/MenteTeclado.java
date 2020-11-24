package logicaJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import movimientoEntidades.Movimiento_Jugador;

public class MenteTeclado extends Juego implements KeyListener {
	
	@Override
	public void inicializarMapa() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		Movimiento_Jugador mov_jugador = (Movimiento_Jugador) this.jugador.getMovimiento();
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
				if ( mov_jugador.puedeMoverse() )
					mov_jugador.moverIzquierda();
				break;
			}
			case KeyEvent.VK_RIGHT: {
				if ( mov_jugador.puedeMoverse() )
					mov_jugador.moverDerecha();
				break;
			}
			case KeyEvent.VK_SPACE: {
				mov_jugador.atacar();
				break;
			}
		}
		this.gui_juego.repaint();
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detenerEnemigos(int duracion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarArmaJugador(int duracion) {
		// TODO Auto-generated method stub
		
	}
	

}
