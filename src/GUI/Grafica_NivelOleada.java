package GUI;



import javax.swing.ImageIcon;

/**
 * Clase que modela la gráfica del nivel y oleada.
 */
public class Grafica_NivelOleada extends Grafica {
	
	/**
	 * Constructor de la gráfica Nivel Oleada.
	 * @param x Posición x.
	 * @param y Posición y.
	 * @param imagen Ruta de la imagen.
	 */
	public Grafica_NivelOleada(String img) {
		super();
		ImageIcon icon = new ImageIcon(this.getClass().getResource(img));
		this.etiqueta.setIcon(icon);
	}
	
	/**
	 * Modifica la etiqueta.
	 */
	public void modificarEtiqueta(String img) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource(img));
		this.etiqueta.setIcon(icon);
		this.etiqueta.repaint();
	}
}
