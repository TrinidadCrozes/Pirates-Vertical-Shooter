package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_SuperArma extends EntidadGrafica{
	/**
	 * Constructor de la entidad gráfica del premio.
	 */
	public EntidadGrafica_SuperArma() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bandera.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}
	
}
