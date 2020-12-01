package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Enemigo_Alpha extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del enemigo alpha.
	 */
	public EntidadGrafica_Enemigo_Alpha(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/rosa.gif"));
		acomodarEtiqueta(x,y);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
	@Override
	public void acomodarEtiqueta(int x, int y) {
		this.etiqueta.setBounds(x,y,100,169);
	}

	@Override
	public void modificarEtiqueta() {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/suuuper_rosa.gif"));
		getJLabel().setIcon(imageIcon);
		getJLabel().repaint();
	}
	
}
