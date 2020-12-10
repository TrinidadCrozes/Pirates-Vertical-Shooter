package audio;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Clase que modela el sonido del juego.
 */
public class Musica extends Thread{
	protected final Player pl;
	
	/**
	 * Constructor de la música.
	 * @throws FileNotFoundException
	 * @throws JavaLayerException
	 */
	public Musica() throws FileNotFoundException, JavaLayerException {
		String rutaArchivo = "audio/cancion.mp3";
		InputStream in = Musica.class.getClassLoader().getResourceAsStream(rutaArchivo);
		pl = new Player(in);
	}
	
	@Override
	public void run(){
		try {
            while (!pl.isComplete()) {
				pl.play(); 
			}
        } 
		catch (JavaLayerException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Activa la música del juego. 
	 */
	public void audioOn() {	
		start();
	}

	/**
	 * Detiene la música del juego.
	 */
	@SuppressWarnings("deprecation")
	public void audioOff() {
		stop();
	}
}