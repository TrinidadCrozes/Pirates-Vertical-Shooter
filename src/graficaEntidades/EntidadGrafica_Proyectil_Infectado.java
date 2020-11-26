package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Proyectil_Infectado extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del proyectil infectado.
	 */
	public EntidadGrafica_Proyectil_Infectado(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bomba.png"));
		this.etiqueta.setBounds(x,y,30,30);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
}

