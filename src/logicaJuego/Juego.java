package logicaJuego;

import logicaEntidades.*;
import movimientoEntidades.Movimiento_Jugador;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import GUI.JFrameJuego;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.Thread;

/**
 * Clase que implementa la lógica del juego.
 */
public class Juego extends Thread {
	protected Jugador jugador;
	protected final Point posInicialJugador = new Point(150, 520);

	protected JFrameJuego gui_juego;
	protected MenteTeclado teclado = new MenteTeclado(this);

	protected List<Entidad> objetos_en_el_mapa = new ArrayList<Entidad>();
	protected List<Entidad> objetos_en_el_mapa_aux = new ArrayList<Entidad>();

	protected int tiempoCuarentena = 0;
	protected int tiempoSuperArma = 0;
	protected Nivel nivel;
	protected int oleadaActual;
	protected final int esperarSigOleada = 100;
	protected int esperar_enemigo = 0;
	protected int esperar_disparo = 0;
	protected int enemigos_juego = 0;

	/**
	 * Inicializa el mapa con el nivel y el jugador.
	 */
	public void inicializarMapa() {
		nivel = new Nivel1(this);
		oleadaActual = 1;
		this.gui_juego.mostrarNivelOleada(nivel.numeroNivel(), oleadaActual);
		inicializarJugador();
	}

	/**
	 * Inicializa el jugador del juego.
	 */
	private void inicializarJugador() {
		Movimiento_Jugador mov_jugador = new Movimiento_Jugador((int) posInicialJugador.getX(),
				(int) posInicialJugador.getY(), this.gui_juego.getHeight(), this);
		this.jugador = Jugador.getJugador(mov_jugador, this);
		this.gui_juego.agregarEntidad(this.jugador);
		this.objetos_en_el_mapa.add(this.jugador);
		this.gui_juego.agregarVidaJugador(this.jugador);
	}

	/**
	 * Inicia la ejecución del hilo del juego.
	 */
	public void jugar() {
		this.start();
	}

	@Override
	public void run() {
		try {
			while (true) {

				this.objetos_en_el_mapa_aux.clear();
				this.objetos_en_el_mapa_aux.addAll(this.objetos_en_el_mapa);
				this.gui_juego.actualizarVidaJugador(this.jugador);
				esperar_disparo--;
				avanzarNivelOleada();

				// Acá desplazamos a la entidad y actualizamos su posición en el mapa.
				for (Entidad entidad : objetos_en_el_mapa_aux) {
					if (!entidad.equals(jugador) && entidad.estaVivo()) {
						entidad.getMovimiento().desplazar();
						entidad.getEntidadGrafica().acomodarEtiqueta((int) entidad.getMovimiento().getPosicion().getX(),
								(int) entidad.getMovimiento().getPosicion().getY());
					}
				}

				// Esperamos cierta cantidad de tiempo antes de añadir un nuevo enemigo al mapa.
				if (esperar_enemigo <= 0) {
					agregarEnemigo();
					esperar_enemigo = 100;
				} else {
					esperar_enemigo--;
				}

				controlarPowerUps();

				disparar();

				// Chequeamos las colisiones entre entidades y las visitamos.
				for (Entidad entidad1 : this.objetos_en_el_mapa_aux) {
					for (Entidad entidad2 : this.objetos_en_el_mapa_aux) {
						if (!entidad1.equals(entidad2)) {
							Rectangle obj1 = entidad1.getEntidadGrafica().getJLabel().getBounds();
							Rectangle obj2 = entidad2.getEntidadGrafica().getJLabel().getBounds();

							if (obj1.intersects(obj2)) {
								entidad2.visitar(entidad1.getVisitor());
							}
						}
					}
				}

				// Chequeamos si las entidades están vivas o muertas y tomamos acciones.
				for (Entidad entidad : objetos_en_el_mapa_aux) {
					if (!entidad.estaVivo()) {
						Premio p = entidad.getMovimiento().lanzarPremio();
						if (p != null) {
							objetos_en_el_mapa.add(p);
							this.gui_juego.agregarEntidad(p);
						}
						objetos_en_el_mapa.remove(entidad);
						this.gui_juego.quitarEntidad(entidad);
						entidad.morir();
					} else {
						entidad.estadoCritico();
						if (tiempoCuarentena > 0) {
							entidad.detener();
						}
					}
				}

				Thread.sleep(100);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Avanza al siguiente nivel o oleada, dependiendo de la oleada en la que se
	 * encuentre.
	 */
	private void avanzarNivelOleada() {
		if (this.nivel.todosEnJuego() && this.enemigos_juego == 0) {
			tiempoCuarentena = 0;
			this.nivel.nadieEnJuego();
			esperar_enemigo = esperarSigOleada;
			if (this.oleadaActual == 1) {
				this.oleadaActual = 2;
				this.gui_juego.actualizarNivelOleada(nivel.numeroNivel(), oleadaActual);
			} else {
				this.nivel = this.nivel.getSiguienteNivel();
				if (this.nivel == null) {
					ganarJuego();
				} else {
					this.oleadaActual = 1;
					this.gui_juego.actualizarNivelOleada(nivel.numeroNivel(), oleadaActual);
				}
			}
		}
	}

	/**
	 * Agrega un enemigo al mapa.
	 */
	private void agregarEnemigo() {
		if (!this.nivel.todosEnJuego()) {
			Entidad enemigo = this.nivel.getEnemigo(this.oleadaActual);
			this.objetos_en_el_mapa.add(enemigo);
			this.gui_juego.agregarEntidad(enemigo);
			this.enemigos_juego++;
		}
	}
	
	/**
	 * Controla si están los power ups activos.
	 */
	private void controlarPowerUps() {
		if (tiempoSuperArma > 0) {
			tiempoSuperArma--;
		} else {
			desactivarSuperArma();
		}
		if (tiempoCuarentena > 0) {
			tiempoCuarentena--;
		} else {
			moverEnemigos();
		}
	}

	/**
	 * Hace que el enemigo lance un proyectil con una cierta probabilidad.
	 */
	private void disparar() {
		Proyectil proyectil = null;
		Random random = new Random();
		int valor = 0;
		for (Entidad infectado : objetos_en_el_mapa_aux) {
			if (infectado.estaVivo()) {
				valor = random.nextInt(50);
				proyectil = infectado.disparar();
				if (valor == 0 && proyectil != null) {
					objetos_en_el_mapa.add(proyectil);
					this.gui_juego.agregarEntidad(proyectil);
				}
			}
		}
	}

	/**
	 * Se gana el juego.
	 */
	public void ganarJuego() {
		this.gui_juego.gano();
		this.gui_juego.cerrar();
	}

	/**
	 * Se pierde el juego.
	 */
	public void perderJuego() {
		this.gui_juego.actualizarVidaJugador(this.jugador);
		this.gui_juego.perdio();
		this.gui_juego.cerrar();
	}

	/**
	 * Detiene a los enemigos una cantidad determinada de tiempo.
	 * 
	 * @param duracion Tiempo que se detienen los enemigos.
	 */
	public void detenerEnemigos(int duracion) {
		tiempoCuarentena = duracion;
		for (Entidad e : objetos_en_el_mapa_aux) {
			e.detener();
		}
	}

	/**
	 * Desplaza nuevamente a los enemigos.
	 */
	public void moverEnemigos() {
		for (Entidad e : objetos_en_el_mapa_aux) {
			e.mover();
		}
	}

	/**
	 * Activa el arma mejorada del jugador.
	 * 
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
	 * 
	 * @param key Tecla apretada.
	 */
	public void mover(int key) {
		this.teclado.mover(key);
	}

	public void decrementarCantEnemigos() {
		this.enemigos_juego--;
	}

	/**
	 * Retorna la lista de entidades en el mapa.
	 * 
	 * @return Lista de entidades.
	 */
	public List<Entidad> getEntidades() {
		return objetos_en_el_mapa;
	}

	/**
	 * Devuelve el JFrameJuego del juego.
	 * 
	 * @return JFrameJuego.
	 */
	public JFrameJuego getJFrameJuego() {
		return this.gui_juego;
	}

	/**
	 * Asigna el JFrameJuego del juego.
	 * 
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
	 * Retorna el tiempo de espera del disparo del jugador. 
	 * @return Tiempo de espera del disparo del jugador.
	 */
	public int getEsperar_disparo() {
		return esperar_disparo;
	}

	/**
	 * Obtiene el tiempo de espera de disparo del jugador.
	 * @param esperar_disparo Tiempo de espera del disparo del jugador.
	 */
	public void setEsperar_disparo(int esperar_disparo) {
		this.esperar_disparo = esperar_disparo;
	}
}
