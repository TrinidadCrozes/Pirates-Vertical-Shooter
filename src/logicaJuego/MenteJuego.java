package logicaJuego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import Fabrica.FabricaAlpha;
import Fabrica.FabricaBeta;
import Fabrica.FabricaInfectado;
import GUI.JFrameJuego;
import logicaEntidades.Entidad;
import logicaEntidades.Infectado;
import logicaEntidades.Jugador;
import logicaEntidades.Proyectil;
import logicaEntidades.Proyectil_Sanitario;
import movimientoEntidades.Movimiento;
import movimientoEntidades.Movimiento_Enemigo;
import movimientoEntidades.Movimiento_Jugador;
import movimientoEntidades.Movimiento_Proyectil_Jugador;

public class MenteJuego extends Juego {

	@Override
	public void inicializarMapa() {
		
		this.nivel = new Nivel1();
		this.objetos_en_el_mapa = new LinkedList<Entidad>();
		inicializarJugador();
		inicializarEnemigos();		
		
	}
	
	/**
	 * Inicializa el jugador del juego.
	 */
	private void inicializarJugador() {

		int mitad_JFrameJuego = (int)(this.gui_juego.getWidth()/2);
		Point pos = new Point(mitad_JFrameJuego, 0);	
		Movimiento_Jugador mov_jugador = new Movimiento_Jugador(mitad_JFrameJuego, 0, 4, this.gui_juego.getHeight());
		Movimiento mov_proyectil_jugador = new Movimiento_Proyectil_Jugador( 0, 0, 10, this.gui_juego.getHeight());
		Proyectil proyectil_jugador = new Proyectil_Sanitario(mov_proyectil_jugador);
		this.jugador = Jugador.getJugador(mov_jugador, proyectil_jugador, this);
		this.gui_juego.agregarJugador(this.jugador, pos);
		
	}
	
	/**
	 * Inicializa la lista de enemigos del juego.
	 */
	private void inicializarEnemigos() {
		
		Infectado inf;
		this.enemigos = new LinkedList<Infectado>();	
		FabricaInfectado fabAlpha = new FabricaAlpha(this);
		FabricaInfectado fabBeta = new FabricaBeta(this);
		for(int i = 0; i < nivel.getCantidadEnemigosAlpha(); i++) {
			inf = fabAlpha.crearInfectado();
			enemigos.add(inf);
		}
		for(int i = 0; i < nivel.getCantidadEnemigosBeta(); i++) {
			inf = fabBeta.crearInfectado();
			enemigos.add(inf);
		}
		
	}
	
	@Override
	public void jugar() {
		this.start();
	}

	public void run() {
		
		boolean condicion = true;
		try {
			Juego.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		this.gui_juego.repaint();
		
	}
	
	/**
	 * Agrega un enemigo al mapa.
	 */
	public void agregarEnemigo() {
		
		Point ubicacion;
		Random rnd = new Random(0);
		int pos_x;
		int pos_lista_enemigo;
				
		if (this.enemigos != null) {
			pos_x = rnd.nextInt(this.gui_juego.getWidth()); 
			pos_lista_enemigo = rnd.nextInt(this.enemigos.size()-1);
			ubicacion = new Point(pos_x, 0);
			this.enemigos.remove(pos_lista_enemigo);
			this.gui_juego.agregarEnemigo(this.enemigos.get(pos_lista_enemigo), ubicacion);
		}
		
	}
	

	public void detenerEnemigos(int duracion) {
		
		for(int i = 0; i < enemigos.size(); i++) {
			Infectado e = enemigos.get(i);
			Movimiento_Enemigo mov = (Movimiento_Enemigo) e.getMovimiento();
			mov.detener(); //No se como manejar lo de la cant de tiempo que lo detengo
		}
		
	}

	public void cambiarArmaJugador(int duracion) {			
		this.jugador.activarArmaEspecial();
		//ver lo de la duración
	}
	
	/**
	 * 
	 * @param e
	 */
	public void insertarObjeto(Entidad e) {
		
		
		
	}
	
	/**
	 * 
	 * @param e
	 */
	public void eliminarObjeto(Entidad e) {
		
		if( objetos_en_el_mapa.contains(e) ) {
			objetos_en_el_mapa.remove(e);
		}			
		
	}
	
	
}
