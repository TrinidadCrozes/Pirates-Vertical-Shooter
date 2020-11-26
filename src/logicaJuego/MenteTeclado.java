package logicaJuego;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import logicaEntidades.Entidad;
import movimientoEntidades.Movimiento;

public class MenteTeclado extends Juego implements KeyListener{
	
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
		Entidad proyectil;
		Movimiento mov_jugador = this.jugador.getMovimiento();
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
					mov_jugador.moverIzquierda();
					System.out.print("se movio");
				break;
			}
			case KeyEvent.VK_RIGHT: {
					mov_jugador.moverDerecha();
					System.out.print("se movio");
				break;
			}
			case KeyEvent.VK_SPACE: {
				proyectil = mov_jugador.atacar();
				this.objetos_en_el_mapa.add(proyectil);
				break;
			}
		}
		
		jugador.getEntidadGrafica().getJLabel().setLocation(jugador.getMovimiento().getPosicion());
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
