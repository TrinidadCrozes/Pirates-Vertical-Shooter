package logicaJuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	protected ArrayList<Entidad> enemigos_primera_oleada = new ArrayList<Entidad>();
	protected ArrayList<Entidad> enemigos_segunda_oleada = new ArrayList<Entidad>();;
	
	public Nivel(Juego juego) {
		this.juego = juego;
	}
	
	/**
	 * Arma las oleadas del juego.
	 * @param cantidadEnemigos Cantidad de enemigos en la oleada.
	 * @param oleada Lista de la oleada a armar.
	 */
	protected void armarOleadas(int cantidadEnemigos,ArrayList<Entidad> oleada) {
		Infectado inf;
		Random ran = new Random();
		int valor;
		FabricaInfectado fabricaA = new FabricaAlpha(juego);
		FabricaInfectado fabricaB = new FabricaBeta(juego);
		for(int i = 0; i < cantidadEnemigos; i++) {
			valor = ran.nextInt(2);
			if(valor % 2 == 0) {
				inf = fabricaA.crearInfectado();
				oleada.add(inf);
				this.juego.getEntidades().add(inf);
			}else {
				inf = fabricaB.crearInfectado();
				oleada.add(inf);
				this.juego.getEntidades().add(inf);
			}			
		}
		System.out.println("primer oleada: "+this.enemigos_primera_oleada.size());
		System.out.println("segunda oleada: "+this.enemigos_segunda_oleada.size());
	}
	
	/**
	 * Retorna el nivel siguiente.
	 * @return Siguiente nivel.
	 */
	public abstract Nivel getSiguienteNivel();
	
	/**
	 * Retorna la primer oleada de enemigos.
	 * @return Primer oleada.
	 */
	protected List<Entidad> getPrimerOleada(){
		return this.enemigos_primera_oleada;
	}
	
	/**
	 * Retorna la segunda oleada de enemigos.
	 * @return Segunda oleada.
	 */
	protected ArrayList<Entidad> getSegundaOleada(){
		return this.enemigos_segunda_oleada;
	}
}
