package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Proyectil_Sanitario extends EntidadGrafica{
	/**
	 * Constructor de la entidad gráfica del proyectil sanitario.
	 */
	public EntidadGrafica_Proyectil_Sanitario() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bomba_pirata.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return this;
	}
}
