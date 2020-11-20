package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Pocion extends EntidadGrafica {
	
	/**
	 * Constructor de la entidad gráfica del premio.
	 */
	public EntidadGrafica_Pocion() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/pocion.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}
	
}
