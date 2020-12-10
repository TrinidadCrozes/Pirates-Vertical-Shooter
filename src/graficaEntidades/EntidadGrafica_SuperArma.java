package graficaEntidades;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Clase que modela la entidad gráfica de la súper arma.
 */
public class EntidadGrafica_SuperArma extends EntidadGrafica {
	
	protected final int desplazamientoX = 31;
	protected final int desplazamientoY = 140;
	/**
	 * Constructor de la entidad gráfica del premio.
	 */
	public EntidadGrafica_SuperArma(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bandera.png"));
		acomodarEtiqueta(x,y);
		this.etiqueta.setIcon(imageIcon);
		Image image = imageIcon.getImage();
		if (image != null) {  
			Image newimg = image.getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH);
			imageIcon.setImage(newimg);
			etiqueta.repaint();
		}
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}
	
	@Override
	public void acomodarEtiqueta(int x, int y) {
		this.etiqueta.setBounds(x+desplazamientoX,y+desplazamientoY,50,50);
	}

}
