package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Enemigo_Alpha extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del enemigo alpha.
	 */
	public EntidadGrafica_Enemigo_Alpha() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/barco_infectado_rosa.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}
	
}
