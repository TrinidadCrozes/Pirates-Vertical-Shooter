package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicaEntidades.Entidad;

public class JFrameJuego extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);	
   
	}
	
	/**
	 * Dispone cada una de las componentes en el mapa.
	 */
	private void initGame() {
		
	}
	
	/**
	 * Comienza el juego.
	 */
	private void startGame() {
		
	}

}
