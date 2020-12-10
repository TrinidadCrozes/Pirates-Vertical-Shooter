package GUI;

import java.awt.EventQueue;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import audio.Musica;
import graficaEntidades.*;
import javazoom.jl.decoder.JavaLayerException;
import logicaEntidades.*;
import logicaJuego.*;

/**
 * Clase que modela la gráfica del juego.
 */
@SuppressWarnings("serial")
public class JFrameJuego extends JFrame {
	private final int ancho = 340;
	private final int altura = 530;
	
	private Musica musica;
	
	private JPanel contentPane;
	private JLabel labelFondo;
	private JPanel panelNivelOleada;
	
	private Juego logicaJuego;
	
	private Grafica_VidaJugador[] labelsVida;
	private Grafica_NivelOleada[] labelsNivelOleada;
	private String[] imagenes = {"/IMG/nivel.png","/IMG/1.png","/IMG/oleada.png","/IMG/2.png"};

	/**
	 * Ejecuta la aplicación.
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
	 * Crea el frame.
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
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/background.gif"));
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
				if (arg0.getKeyCode() == KeyEvent.VK_R) {
					try {
						musica = new Musica();
					} catch (JavaLayerException | FileNotFoundException e) {
						e.printStackTrace();
					}
					musica.audioOn();
				} else {
					if (arg0.getKeyCode() == KeyEvent.VK_F) {
						musica.audioOff();
					} else
						mover(arg0);
				}
				
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

	/**
	 * Agrega gráficamente la vida del jugador.
	 * @param j Jugador.
	 */
	public void agregarVidaJugador(Jugador j) {
		labelsVida = new Grafica_VidaJugador[5];
	
		int ubicacion = this.ancho - 40;
		
		for (int i = 0; i < labelsVida.length; i++) {
			labelsVida[i] = new Grafica_VidaJugador(ubicacion, 10);
			labelFondo.add(labelsVida[i].getJLabel());
			labelFondo.repaint();
			ubicacion+=25;
		}
		
		actualizarVidaJugador(j);
	}
	
	/**
	 * Actualiza gráficamente la vida del jugador.
	 * @param j Jugador.
	 */
	public void actualizarVidaJugador(Jugador j) {
		int vida = j.getVida();
		
		labelsVida[0].agregarVida();
		labelsVida[1].agregarVida();
		labelsVida[2].agregarVida();
		labelsVida[3].agregarVida();
		labelsVida[4].agregarVida();
		
		if (vida <= 0) {
			labelsVida[0].sacarVida();
			labelsVida[1].sacarVida();
			labelsVida[2].sacarVida();
			labelsVida[3].sacarVida();
			labelsVida[4].sacarVida();
		}else {
			if (vida > 0 && vida <= 20) {
				labelsVida[1].sacarVida();
				labelsVida[2].sacarVida();
				labelsVida[3].sacarVida();
				labelsVida[4].sacarVida();
			}else {
				if (vida > 20 && vida <= 40) {
					labelsVida[2].sacarVida();
					labelsVida[3].sacarVida();
					labelsVida[4].sacarVida();
				}else {
					if(vida > 40 && vida <= 60) {
						labelsVida[3].sacarVida();
						labelsVida[4].sacarVida();
					}else {
						if(vida > 60 && vida <= 80) {
							labelsVida[4].sacarVida();
						}
					}
				}
			}
		}
		
		labelFondo.repaint();
	}
	
	/**
	 * Muestra gráficamente en que nivel y oleada se encuentra el juego.
	 * @param nivel int que indica el nivel.
	 * @param oleada int que indica la oleada.
	 */
	public void mostrarNivelOleada(int nivel, int oleada) {
		panelNivelOleada = new JPanel();
		panelNivelOleada.setOpaque(false);
		panelNivelOleada.setBounds(10, 7, 250, 50);
		labelsNivelOleada = new Grafica_NivelOleada[4];
		for(int i = 0; i < labelsNivelOleada.length; i++) {
			labelsNivelOleada[i] = new Grafica_NivelOleada(imagenes[i]);
			panelNivelOleada.add(labelsNivelOleada[i].getJLabel());
		}
		labelFondo.add(panelNivelOleada);
		actualizarNivelOleada(nivel,oleada);
	}
	
	/**
	 * Actualiza el nivel y oleada en que se encuentra.
	 * @param nivel int nuevo nivel.
	 * @param oleada int nueva oleada.
	 */
	public void actualizarNivelOleada(int nivel,int oleada) {
		switch(nivel) {
		case 1: labelsNivelOleada[1].modificarEtiqueta(imagenes[1]);
				break;
		default : labelsNivelOleada[1].modificarEtiqueta(imagenes[3]);
				break;
		}
		
		switch(oleada) {
			case 1: labelsNivelOleada[3].modificarEtiqueta(imagenes[1]); 
					break;
			default : labelsNivelOleada[3].modificarEtiqueta(imagenes[3]);
					break;
		}
	}

}
