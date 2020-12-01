package graficaEntidades;

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
	 * Acomoda la etiqueta en la ubicación que especifica.
	 * @param x Posicion x.
	 * @param y Posicion y.
	 */
	public abstract void acomodarEtiqueta(int x, int y);
	
	/**
	 * Modifica la etiqueta.
	 */
	public abstract void modificarEtiqueta();
	
}
