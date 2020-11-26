
package logicaJuego;


/**
 * Clase que modela el primer nivel del juego.
 */
public class Nivel1 extends Nivel {
	protected final int cantEnemigosOleada = 10;
	
	/**
	 * Constructor del nivel 1.
	 * @param juego Juego.
	 */
	public Nivel1(Juego juego) {
		super(juego);
		this.siguienteNivel = new Nivel2(juego);
		this.armarOleadas(cantEnemigosOleada,this.enemigos_primera_oleada);
		this.armarOleadas(cantEnemigosOleada,this.enemigos_segunda_oleada);
	}

	@Override
	public Nivel getSiguienteNivel() {
		return this.siguienteNivel;
	}
	
}
