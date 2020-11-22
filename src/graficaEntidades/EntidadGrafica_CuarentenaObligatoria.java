package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_CuarentenaObligatoria extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del premio.
	 */
	public EntidadGrafica_CuarentenaObligatoria() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/brujula.png"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}

	
	public EntidadGrafica getEntidadGrafica() {
		return this;
	}
	
	
	
}
