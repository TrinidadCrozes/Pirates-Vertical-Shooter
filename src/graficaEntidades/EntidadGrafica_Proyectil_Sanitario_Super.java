package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Proyectil_Sanitario_Super extends EntidadGrafica{
	/**
	 * Constructor de la entidad gráfica del proyectil sanitario mejorado.
	 */
	public EntidadGrafica_Proyectil_Sanitario_Super(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bomba_pirata_recargada.png"));
		this.etiqueta.setBounds(x,y,30,30);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
}
