package graficaEntidades;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase que modela las entidades gráficas del juego.
 */
public abstract class EntidadGrafica {
	protected JLabel etiqueta;
	
	/**
	 * Constructor de la entidad gráfica.
	 */
	public EntidadGrafica() {
		this.etiqueta = new JLabel();
	}
	
	/**
	 * Retorna el JLabel.
	 * @return JLabel.
	 */
	public JLabel getJLabel() {
		return this.etiqueta;
	}
	
	/**
	 * Redimensiona las imagenes del juego.
	 * @param label Etiqueta en la que se va a redimensionar la imagen.
	 * @param grafico Imagen a redimensionar.
	 */
	public void redimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {  
			Image newimg = image.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.repaint();
		}
	}
	
}
