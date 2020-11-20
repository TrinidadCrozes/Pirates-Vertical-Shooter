package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Proyectil_Sanitario_Super extends EntidadGrafica{
	/**
	 * Constructor de la entidad gráfica del proyectil sanitario mejorado.
	 */
	public EntidadGrafica_Proyectil_Sanitario_Super() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bomba_pirata_recargada.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}
}
