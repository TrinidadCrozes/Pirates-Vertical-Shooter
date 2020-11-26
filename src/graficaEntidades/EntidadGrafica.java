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
	
}
