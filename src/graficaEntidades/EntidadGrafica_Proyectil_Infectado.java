package graficaEntidades;

import javax.swing.ImageIcon;

public class EntidadGrafica_Proyectil_Infectado extends EntidadGrafica{
	
	/**
	 * Constructor de la entidad gráfica del proyectil infectado.
	 */
	public EntidadGrafica_Proyectil_Infectado(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/bomba.png"));
		this.etiqueta.setBounds(x+31,y+140,20,20);
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
	
}

