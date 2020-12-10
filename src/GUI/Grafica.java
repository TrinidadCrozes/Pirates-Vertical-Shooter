package GUI;

import javax.swing.JLabel;

/**
 * Clase que modela gráficas del juego.
 */
public abstract class Grafica {
	protected JLabel etiqueta;
	
	/**
	 * Constructor de la gráfica.
	 */
	public Grafica() {
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
