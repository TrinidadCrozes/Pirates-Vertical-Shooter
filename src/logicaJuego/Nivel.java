package logicaJuego;


import java.util.Random;
import java.util.Stack;

import Fabrica.FabricaAlpha;
import Fabrica.FabricaBeta;
import Fabrica.FabricaInfectado;
import logicaEntidades.Entidad;
import logicaEntidades.Infectado;

/**
 * Clase que modela un nivel del juego.
 */
public abstract class Nivel {
	
	protected Juego juego;
	protected Nivel siguienteNivel;
	protected Stack<Entidad> enemigos_primera_oleada = new Stack<Entidad>();
	protected Stack<Entidad> enemigos_segunda_oleada = new Stack<Entidad>();;
	
	public Nivel(Juego juego) {
		this.juego = juego;
	}
	
	/**
	 * Arma las oleadas del juego.
	 * @param cantidadEnemigos Cantidad de enemigos en la oleada.
	 * @param oleada Lista de la oleada a armar.
	 */
	protected void armarOleadas(int cantidadEnemigos,Stack<Entidad> oleada) {
		Infectado inf;
		Random ran = new Random();
		int valor;
		FabricaInfectado fabricaA = new FabricaAlpha(juego);
		FabricaInfectado fabricaB = new FabricaBeta(juego);
		for(int i = 0; i < cantidadEnemigos; i++) {
			valor = ran.nextInt(2);
			if(valor % 2 == 0) {
				inf = fabricaA.crearInfectado();
				oleada.push(inf);
			}else {
				inf = fabricaB.crearInfectado();
				oleada.push(inf);
			}			
		}
	}
	
	/**
	 * Obtiene un enemigo de la oleada correspondiente.
	 * @param oleada Numero de la oleada.
	 * @return Enemigo de la oleada.
	 */
	public abstract Entidad getEnemigo(int oleada);
	
	/**
	 * Analiza si todos los enemigos ya fueron puestos en el mapa.
	 * @return True si todos los enemigos de la oleada estan en el juego, false en caso contrario.
	 */
	public abstract boolean todosEnJuego();
	
	/**
	 * Retorna el nivel siguiente.
	 * @return Siguiente nivel.
	 */
	public abstract Nivel getSiguienteNivel();
	
	/**
	 * Avisa que ya no hay nadie en juego.
	 */
	public abstract void nadieEnJuego();
	
	/**
	 * Retorna la primer oleada de enemigos.
	 * @return Primer oleada.
	 */
	protected Stack<Entidad> getPrimerOleada(){
		return this.enemigos_primera_oleada;
	}
	
	/**
	 * Retorna la segunda oleada de enemigos.
	 * @return Segunda oleada.
	 */
	protected Stack<Entidad> getSegundaOleada(){
		return this.enemigos_segunda_oleada;
	}
}
