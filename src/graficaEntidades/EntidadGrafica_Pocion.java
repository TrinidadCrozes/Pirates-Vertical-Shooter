package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Pocion extends EntidadGrafica {
	
	/**
	 * Constructor de la entidad gráfica del premio.
	 */
	public EntidadGrafica_Pocion(int x,int y) {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/pocion.png"));
		this.etiqueta.setBounds(x,y,50,50);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
}
