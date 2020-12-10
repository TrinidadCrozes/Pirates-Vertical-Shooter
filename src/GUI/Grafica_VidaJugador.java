package GUI;

import javax.swing.ImageIcon;

/**
 * Clase que modela la gráfica de la vida del jugador.
 */
public class Grafica_VidaJugador extends Grafica {
	
	/**
	 * Constructor de la entidad gráfica de la vida del jugador.
	 */
	public Grafica_VidaJugador(int x,int y) {
		super();
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/corazon_sinvida.png"));
		this.etiqueta.setBounds(x,y,25,25);
		this.etiqueta.setIcon(imageIcon);
		imageIcon.setImageObserver(this.etiqueta);
		this.etiqueta.repaint();
	}


	/**
	 * Modifica la imagen agregándole vida.
	 */
	public void agregarVida() {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/corazon.png"));
		getJLabel().setIcon(imageIcon);
		getJLabel().repaint();
	}
	
	/**
	 * Modifica la imagen sacandole vida.
	 */
	public void sacarVida() {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/IMG/corazon_sinvida.png"));
		getJLabel().setIcon(imageIcon);
		getJLabel().repaint();
	}

}
