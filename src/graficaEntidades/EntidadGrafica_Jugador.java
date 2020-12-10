package graficaEntidades;

import javax.swing.ImageIcon;

/**
 * Clase que modela la entidad gráfica del jugador.
 */
public class EntidadGrafica_Jugador extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del jugador.
	 */
	public EntidadGrafica_Jugador(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/jugador.gif"));
		acomodarEtiqueta(x,y);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
	@Override
	public void acomodarEtiqueta(int x, int y) {
		this.etiqueta.setBounds(x,y,100,179);
	}
	
}

