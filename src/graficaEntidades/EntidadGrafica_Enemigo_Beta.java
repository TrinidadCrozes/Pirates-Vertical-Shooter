package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Enemigo_Beta extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del enemigo beta.
	 */
	public EntidadGrafica_Enemigo_Beta(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/barco_infectado_azul.png"));
		this.etiqueta.setBounds(x,y,100,169);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
}
