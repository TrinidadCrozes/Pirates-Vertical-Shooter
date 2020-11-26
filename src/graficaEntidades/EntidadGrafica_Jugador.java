package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Jugador extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del jugador.
	 */
	public EntidadGrafica_Jugador(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/barco_pirata.gif"));
		this.etiqueta.setBounds(x,y,100,169);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
}

