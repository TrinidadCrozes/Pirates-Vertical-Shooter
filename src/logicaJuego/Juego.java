package logicaJuego;

import logicaEntidades.*;


import movimientoEntidades.Movimiento;
import movimientoEntidades.Movimiento_Enemigo;
import movimientoEntidades.Movimiento_Enemigo_Mejorado;
import movimientoEntidades.Movimiento_Jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import GUI.JFrameJuego;
import graficaEntidades.EntidadGrafica;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.lang.Thread;

/**
 * Clase que implementa la lógica del juego.
 */
public class Juego extends Thread {
	protected Jugador jugador;
	protected final Point posInicialJugador = new Point(150,530);
	protected final int velocidadInicial = 2;
	
	protected JFrameJuego gui_juego;
	
	protected List<Entidad> enemigos = new ArrayList<Entidad>();
	protected List<Entidad> entidades_a_eliminar = new ArrayList<Entidad>();
	protected List<Entidad> objetos_en_el_mapa = new ArrayList<Entidad>();
	protected ArrayList<Entidad> enemigo_premio = new ArrayList<Entidad>();
	protected ArrayList<Entidad> enemigo_proyectil = new ArrayList<Entidad>();
	
	protected Nivel nivel;
	protected int tiempoCuarentena = 0; 
	protected int tiempoSuperArma = 0; 
	protected boolean jugando = true;
	protected int oleadaActual;
	protected final int esperarSigOleada = 100;
	protected int esperar = 0;
	protected int enemigosEnJuego = 0;
	
	/**
	 * Inicializa el mapa con el nivel y el jugador.
	 */
	public void inicializarMapa() {
		nivel = new Nivel1(this);
		oleadaActual = 1;
		inicializarJugador();	
	}
	
	/**
	 * Inicializa el jugador del juego.
	 */
	private void inicializarJugador() {
		Movimiento_Jugador mov_jugador = new Movimiento_Jugador(posInicialJugador.x,posInicialJugador.y, velocidadInicial, this.gui_juego.getHeight(),this);
		this.jugador = Jugador.getJugador(mov_jugador, this);
		this.gui_juego.agregarEntidad(this.jugador);
		this.objetos_en_el_mapa.add(this.jugador);
	}

	/**
	 * Inicia la ejecución del hilo del juego.
	 */
	public void jugar() {
		this.start();
	}

	public void run() {
		try {
			while (jugando) {
				//System.out.println(this.jugador.getVida());
				enemigo_premio.clear();
				enemigo_proyectil.clear();
				avanzarNivelOleada();
				
				//Acá desplazamos a la entidad y actualizamos su posición en el mapa.
				for (Entidad entidad : objetos_en_el_mapa) {
					if(!entidad.equals(jugador)) {
						entidad.getMovimiento().desplazar();
						entidad.getEntidadGrafica().acomodarEtiqueta(entidad.getMovimiento().getPosicion().x, entidad.getMovimiento().getPosicion().y);
					}
				}
				
				//Esperamos cierta cantidad de tiempo antes de añadir un nuevo enemigo al mapa.
				if(esperar <= 0) {
					agregarEnemigo();
					esperar = 100;
				}else {
					esperar--;
				}
				
				controlarPowerUps();
				
				for(Entidad enemigo : enemigos) {
					if(enemigo.estadoCritico()) {
						boolean puedeMoverse = enemigo.getMovimiento().puedeMoverse();
						Movimiento_Enemigo m = new Movimiento_Enemigo_Mejorado(enemigo.getMovimiento().getPosicion().x,enemigo.getMovimiento().getPosicion().y,2,this.gui_juego.getHeight());
						enemigo.setMovimiento(m);
						if(!puedeMoverse) {
							m.detener();
						}
						EntidadGrafica g = enemigo.getEntidadGrafica();
						g.modificarEtiqueta();
					}
					enemigo_proyectil.add(enemigo);
				}
				
				disparar();
				
				for (Entidad entidad1 : this.objetos_en_el_mapa) {
					for (Entidad entidad2 : this.objetos_en_el_mapa) {
						if (!entidad1.equals(entidad2)) {
							Rectangle obj1 = entidad1.getEntidadGrafica().getJLabel().getBounds();
							Rectangle obj2 = entidad2.getEntidadGrafica().getJLabel().getBounds();

							if (obj1.intersects(obj2)) {
								entidad2.visitar(entidad1.getVisitor());
							}
						}
					}
				}
				
				for (Entidad entidad : objetos_en_el_mapa) {
					if (!entidad.estaVivo()) {
						if(entidad.equals(jugador)) {
							perderJuego();
						}
						Premio p = entidad.getMovimiento().lanzarPremio();
						if(p != null) {
							this.enemigo_premio.add(p);
							this.gui_juego.agregarEntidad(p);
						}
						entidades_a_eliminar.add(entidad);
						this.gui_juego.quitarEntidad(entidad);
					}
				}
				
				eliminarEliminables();
				
				for(Entidad p : this.enemigo_premio) {
					this.objetos_en_el_mapa.add(p);
				}
				
				Thread.sleep(100);
			}
			
			this.gui_juego.repaint();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Agrega un enemigo al mapa.
	 */
	public void agregarEnemigo() { 
		if(!this.nivel.todosEnJuego()) {
			Entidad enemigo = this.nivel.getEnemigo(this.oleadaActual);
			this.objetos_en_el_mapa.add(enemigo);
			this.gui_juego.agregarEntidad(enemigo);
			this.enemigos.add(enemigo);
		}
	}
	
	/**
	 * Hace que el enemigo lance un proyectil.
	 */
	private void disparar() {
		Proyectil proyectil = null;
		Random random = new Random();
		int valor = 0;
		for (Entidad infectados: enemigos) {
			valor = random.nextInt(50);
			if (valor == 0) {
				proyectil = infectados.getMovimiento().atacar();
				objetos_en_el_mapa.add(proyectil);
				this.gui_juego.agregarEntidad(proyectil);
			}
		}
	}
	
	/**
	 * Controla si están los power ups activos.
	 */
	private void controlarPowerUps() {
		if(tiempoSuperArma > 0) {
			tiempoSuperArma--;
		}else {
			desactivarSuperArma();
		}
		if(tiempoCuarentena > 0) {
			tiempoCuarentena--;
		}else {
			moverEnemigos();
		}
	}
	
	/**
	 * Avanza al siguiente nivel o oleada, dependiendo de la oleada en la que se encuentre.
	 */
	private void avanzarNivelOleada() {
		if(this.nivel.todosEnJuego() && this.enemigos.isEmpty()) {
			this.nivel.nadieEnJuego();
			esperar = esperarSigOleada;
			System.out.print(esperar);
			if(this.oleadaActual == 1) {
				this.oleadaActual = 2;
			}else {
				this.nivel = this.nivel.getSiguienteNivel();
				if(this.nivel == null) {
					ganarJuego();
				}else {
					this.oleadaActual = 1;
				}
			}
		}
	}
	
	/**
	 * Se gana el juego.
	 */
	private void ganarJuego() {
		this.gui_juego.gano();
		this.gui_juego.cerrar();
	}
	
	/**
	 * Se pierde el juego.
	 */
	private void perderJuego() {
		this.gui_juego.perdio();
		this.gui_juego.cerrar();
	}

	/**
	 * Elimina las entidades sin vida del mapa o si se salieron del frame (para los premios).
	 */
	private void eliminarEliminables() {
        Iterator<Entidad> i = this.entidades_a_eliminar.iterator();
        while( i.hasNext() ) {
            Entidad bala = i.next();
            this.objetos_en_el_mapa.remove(bala);
            this.enemigos.remove(bala);
        }
        this.entidades_a_eliminar = new Vector<Entidad>();
    }

	/**
	 * Detiene a los enemigos una cantidad determinada de tiempo.
	 * @param duracion Tiempo que se detienen los enemigos.
	 */
	public void detenerEnemigos(int duracion) {
		for(int i = 0; i < enemigos.size(); i++) {
			Entidad e = enemigos.get(i);
			Movimiento_Enemigo mov = (Movimiento_Enemigo) e.getMovimiento();
			mov.detener();
			tiempoCuarentena = duracion;
		}
	}
	
	/**
	 * Desplaza nuevamente a los enemigos.
	 */
	public void moverEnemigos() {
		for(int i = 0; i < enemigos.size(); i++) {
			Entidad e = enemigos.get(i);
			Movimiento_Enemigo mov = (Movimiento_Enemigo) e.getMovimiento();
			mov.mover();
		}
	}
	
	/**
	 * Activa el arma mejorada del jugador.
	 * @param duracion Arma mejorada.
	 */
	public void cambiarArmaJugador(int duracion) {			
		this.jugador.activarArmaEspecial();
		tiempoSuperArma = duracion;
	}
	
	/**
	 * Desactiva el super arma del jugador.
	 */
	public void desactivarSuperArma() {
		this.jugador.desactivarArmaEspecial();
	}
	
	/**
	 * Mueve al jugador.
	 * @param key Tecla apretada.
	 */
	public void mover(int key) {
		Entidad proyectil;
		Movimiento mov_jugador = this.jugador.getMovimiento();
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
				proyectil = mov_jugador.atacar();
				this.objetos_en_el_mapa.add(proyectil);
				this.gui_juego.agregarEntidad(proyectil);
				break;
			}
		}
		
		jugador.getEntidadGrafica().getJLabel().setLocation(jugador.getMovimiento().getPosicion());
		
	}

	
	/**
	 * Retorna la lista de entidades en el mapa.
	 * @return Lista de entidades.
	 */
	public List<Entidad> getEntidades(){
		return objetos_en_el_mapa;
	}
	
	/**
	 * Devuelve el JFrameJuego del juego.
	 * @return JFrameJuego.
	 */
	public JFrameJuego getJFrameJuego() {
		return this.gui_juego;
	}
	
	/**
	 * Asigna el JFrameJuego del juego.
	 * @param frameJuego JFrameJuego a asignar.
	 */
	public void setJFrameJuego(JFrameJuego frameJuego) {
		this.gui_juego = frameJuego;
	}

	/**
	 * Retorna el jugador del juego.
	 * @return Jugador.
	 */
	public Jugador getJugador() {
		return this.jugador;
	}
	
	/**
	 * Retorna el jugador del juego.
	 * @return Jugador.
	 */
	public void setJugador(Jugador j) {
		this.jugador = j;
	}

}
