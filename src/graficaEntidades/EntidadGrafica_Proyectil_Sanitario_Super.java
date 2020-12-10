package graficaEntidades;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Clase que modela la entidad gráfica del súper proyectil sanitario.
 */
public class EntidadGrafica_Proyectil_Sanitario_Super extends EntidadGrafica {
	
	protected final int desplazamientoX = 30;
	protected final int desplazamientoY = -10;
	/**
	 * Constructor de la entidad gráfica del proyectil sanitario mejorado.
	 */
	public EntidadGrafica_Proyectil_Sanitario_Super(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bomba_pirata_recargada.png"));
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
		this.etiqueta.setBounds(x+desplazamientoX,y+desplazamientoY,20,20);
	}

}

