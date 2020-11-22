package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Proyectil_Infectado extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del proyectil infectado.
	 */
	public EntidadGrafica_Proyectil_Infectado() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bomba.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}

	
	public EntidadGrafica getEntidadGrafica() {
		return this;
	}
	
}
