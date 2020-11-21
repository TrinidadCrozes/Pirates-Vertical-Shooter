package GUI;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon imagen;
	String nombre;
	
	/**
	 * Crea un nuevo panel con la imagen deseada de fondo. 
	 */
	public PanelImagen() {
		nombre = "/IMG/background.gif";
	}
	
	/**
	 * Metodo que configura el estado interno del panel con imagen. 
	 */
	public void paint(Graphics g) {
		Dimension tamaño = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamaño.width, tamaño.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
