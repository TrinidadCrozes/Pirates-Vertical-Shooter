package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import graficaEntidades.*;
import logicaEntidades.*;
import logicaJuego.*;


@SuppressWarnings("serial")
public class JFrameJuego extends JFrame {
	private final int ancho = 330;
	private final int altura = 530;
	
	private JPanel contentPane;
	private JLabel labelFondo;
	private Juego logicaJuego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(3000);
        splash.showSplash();
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
		setTitle("Pirate's Vertical Shooter");
		ImageIcon icono = new ImageIcon(this.getClass().getResource("/IMG/bandera.png"));
		setIconImage(icono.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 0, 450, 740);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		labelFondo = new JLabel();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/fondito.gif"));
		labelFondo.setBounds(0, 0, 450, 740);
		labelFondo.setIcon(imageIcon);
		imageIcon.setImageObserver(labelFondo);
		labelFondo.repaint();
	
		contentPane.add(labelFondo);
	
	}
	

	/**
	 * Dispone cada una de las componentes en el mapa.
	 */
	private void initGame() {
		
		this.logicaJuego = new Juego();
		this.logicaJuego.setJFrameJuego(this);
		this.logicaJuego.inicializarMapa();
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
	}
	
	/**
	 * Muestra graficamente que el jugador perdio. 
	 */
	public void perdio() {
		JLabel labelGif = new JLabel();
		labelGif.setSize(417, 305);
		ImageIcon gif = new ImageIcon(JFrameJuego.class.getResource("/IMG/perdio.gif"));
		Icon icono = new ImageIcon(gif.getImage().getScaledInstance(labelGif.getWidth(), labelGif.getHeight(), Image.SCALE_DEFAULT));
		
		JOptionPane.showMessageDialog(rootPane, "El próximo será mas fácil, lo prometo ", "PERDISTE", JOptionPane.PLAIN_MESSAGE, icono);
	}
	
	
	/**
	 * Muestra graficamente que el jugador ganó.
	 */
	public void gano() {
		JLabel labelGif = new JLabel();
		labelGif.setSize(417, 305);
		ImageIcon gif = new ImageIcon(JFrameJuego.class.getResource("/IMG/gano.gif"));
		Icon icono = new ImageIcon(gif.getImage().getScaledInstance(labelGif.getWidth(), labelGif.getHeight(), Image.SCALE_DEFAULT));
		
		JOptionPane.showMessageDialog(rootPane, "YES BAAAABY!! ", "GANASTE", JOptionPane.PLAIN_MESSAGE, icono);
	}
	
	/**
	 * Cierra la ventana.
	 */
	public void cerrar() {
		System.exit(0);
	}
	
	/**
	 * Mueve el jugador de acuerdo al KeyEvent pasado como parámetro.
	 * @param key KeyEvent.
	 */
	private void mover(KeyEvent key) {
		this.logicaJuego.mover(key.getKeyCode());
		this.repaint();
	}
	
	/**
	 * Comienza el juego.
	 */
	private void startGame() {
		this.logicaJuego.jugar();
	}
	
	@Override
	public int getWidth() {
		return this.ancho;
	}
	
	@Override
	public int getHeight() {
		return this.altura;
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
		if( pos_x > this.getWidth() || pos_x < 0 || pos_y < 0 || pos_y > 740 )
			fueraDePantalla = true;
		return fueraDePantalla;
		
	}
	
	/**
	 * Agrega gráficamente una entidad al mapa.
	 * @param entidad Entidad a agregar.
	 */
	public void agregarEntidad(Entidad entidad) {
		EntidadGrafica grafica = entidad.getEntidadGrafica();
		JLabel label = grafica.getJLabel();
		labelFondo.add(label);
		labelFondo.repaint();
	}
	
	/**
	 * Elimina la entidad del mapa.
	 * @param entidad Entidad a eliminar.
	 */
	public void quitarEntidad(Entidad entidad) {
		EntidadGrafica grafica = entidad.getEntidadGrafica();
		JLabel label = grafica.getJLabel();
		labelFondo.remove(label);
		labelFondo.repaint();
	}
}
