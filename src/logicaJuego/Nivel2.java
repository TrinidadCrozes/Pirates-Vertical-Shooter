  
package logicaJuego;

/**
 * Clase que modela el nivel 2 del juego.
 */
public class Nivel2 extends Nivel {
	protected final int cantidadEnemigosOleada = 15;

	/**
	 * Constructor del nivel.
	 * @param juego Juego.
	 */
	public Nivel2(Juego juego) {
		super(juego);
		this.siguienteNivel = null;
		this.armarOleadas(cantidadEnemigosOleada,this.enemigos_primera_oleada);
		this.armarOleadas(cantidadEnemigosOleada,this.enemigos_segunda_oleada);
	}

	@Override
	public Nivel getSiguienteNivel() {
		return this.siguienteNivel;
	}

}
