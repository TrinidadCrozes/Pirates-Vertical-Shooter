package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Jugador extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del jugador.
	 */
	public EntidadGrafica_Jugador() {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/jugador.gif"));
		redimensionar(this.etiqueta,imageIcon);
		this.etiqueta.setIcon(imageIcon);
	}
	
}
