package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graficaEntidades.*;
import logicaEntidades.*;
import logicaJuego.*;


@SuppressWarnings("serial")
public class JFrameJuego extends JFrame {

	private JPanel contentPane;
	private JLabel labelFondo;
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
		setTitle("Vertical Shooter");
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
		
		this.logicaJuego = new MenteJuego();
		this.logicaJuego.setJFrameJuego(this);
		this.logicaTeclado = new MenteTeclado();
		this.logicaTeclado.setJFrameJuego(this);
		
		this.logicaJuego.inicializarMapa();
		this.addKeyListener((KeyListener) logicaTeclado);
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
		this.remove(label);
		labelFondo.repaint();
	}
}
