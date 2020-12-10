package graficaEntidades;

import javax.swing.ImageIcon;

/**
 * Clase que modela la entidad gráfica del enemigo Beta.
 */
public class EntidadGrafica_Enemigo_Beta extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del enemigo beta.
	 */
	public EntidadGrafica_Enemigo_Beta(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/azul.gif"));
		acomodarEtiqueta(x,y);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
	@Override
	public void acomodarEtiqueta(int x, int y) {
		this.etiqueta.setBounds(x,y,100,169);
	}
}
