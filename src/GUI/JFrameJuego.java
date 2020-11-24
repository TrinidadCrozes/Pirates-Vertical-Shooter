package GUI;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graficaEntidades.*;
import logicaEntidades.*;
import logicaJuego.*;

public class JFrameJuego extends JFrame {

	private JPanel contentPane;
	private MenteJuego logicaJuego;
	private MenteTeclado logicaTeclado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameJuego frame = new JFrameJuego();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameJuego() {
		
		initGUI();
		initGame();
		startGame();
		
	}
	
	/**
	 * Inicializa el JFrame del juego.
	 */	
	private void initGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 0, 450, 740);
		contentPane = new PanelImagen();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	

	/**
	 * Dispone cada una de las componentes en el mapa.
	 */
	
	private void initGame() {
		
		this.logicaJuego = new MenteJuego();
		this.logicaJuego.setJFrameJuego(this);
		this.logicaTeclado = new MenteTeclado();
		this.logicaTeclado.setJFrameJuego(this);
		
		this.logicaJuego.inicializarMapa();
		
	}
	
	/**
	 * Comienza el juego.
	 */
	private void startGame() {
		
		this.logicaJuego.jugar();
		
	}
	
	/**
	 * Indica si la entidad pasada como parámetro está dentro de la pantalla visible o no.
	 * @param e Entidad.
	 * @return boolean true si está fuera de pantalla, y false en caso contrario.
	 */
	public boolean estaFueraDePantalla(Entidad e) {
		
		boolean fueraDePantalla = false;
		int pos_x = e.getEntidadGrafica().getJLabel().getLocation().x;
		int pos_y = e.getEntidadGrafica().getJLabel().getLocation().y;
		if( pos_x > 450 || pos_x < 0 || pos_y < 0 || pos_y > 740 )
			fueraDePantalla = true;
		return fueraDePantalla;
		
	}

	/**
	 * Agrega gráficamente un enemigo al mapa.
	 * @param enemigo Infectado a agregar.
	 * @param ubicacion Point donde debe aparecer el enemigo.
	 */
	public void agregarEnemigo(Infectado enemigo, Point ubicacion) {
		
		
		
	}
	
	/**
	 * Agrega gráficamente el jugador al mapa.
	 * @param jugador Jugador a agregar.
	 * @param ubicacion Point donde debe aparecer el jugador.
	 */
	public void agregarJugador(Jugador jugador, Point ubicacion) {
		
		EntidadGrafica graficaJugador = jugador.getEntidadGrafica();
		JLabel labelJugador = graficaJugador.getJLabel();
		labelJugador.setLocation(ubicacion);
		contentPane.add(labelJugador);
		contentPane.repaint();
				
	}
}
