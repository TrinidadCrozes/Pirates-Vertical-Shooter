package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graficaEntidades.*;
import logicaEntidades.*;
import logicaJuego.Juego;

public class JFrameJuego extends JFrame {

	private JPanel contentPane;
	private Juego logicaJuego;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}
	

	/**
	 * Dispone cada una de las componentes en el mapa.
	 */
	private void initGame() {
		
		this.logicaJuego = new Juego(this);
		
	}
	
	/**
	 * Comienza el juego.
	 */
	private void startGame() {
		
		
		
	}
	
	/**
	 * Indica si la entidad pasada como parámetro está dentro de la pantalla visible o no.
	 * @param e Entidad.
	 * @return boolean true si está fuera de pantalla, y false en caso contrario.
	 */
	public boolean estaFueraDePantalla(Entidad e) {
		
		boolean fueraDePantalla = true;
		return fueraDePantalla;
		
	}

	/**
	 * 
	 * @param enemigo
	 * @param ubicacion
	 */
	public void agregarEnemigo(Infectado enemigo, Point ubicacion) {
		
		
		
	}
	
	/**
	 * 
	 * @param jugador
	 * @param ubicacion
	 */
	public void agregarJugador(Jugador jugador, Point ubicacion) {
		
		EntidadGrafica graficaJugador = jugador.getEntidadGrafica();
		JLabel labelJugador = graficaJugador.getJLabel();
		labelJugador.setLocation(ubicacion);
		contentPane.add(labelJugador);
				
	}

}
