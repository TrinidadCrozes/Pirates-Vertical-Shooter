package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_CuarentenaObligatoria extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del premio.
	 */
	public EntidadGrafica_CuarentenaObligatoria(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/brujula.png"));
		this.etiqueta.setBounds(x,y,50,50);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
}
