package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Enemigo_Beta extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del enemigo beta.
	 */
	public EntidadGrafica_Enemigo_Beta() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/barco_infectado_azul.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}
	
}
