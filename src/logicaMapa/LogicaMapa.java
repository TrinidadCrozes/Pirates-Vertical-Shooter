package logicaMapa;

import GUI.Juego;
import logicaEntidades.*;

import java.util.LinkedList;
import java.util.List;
import java.awt.Point;

/**
 * Clase que implementa la lógica del mapa del juego.
 */
public class LogicaMapa extends Thread {
	
	protected Juego juego;
	protected Personaje barco_pirata;
	protected List<Infectado> barcos_infectados;
	protected List<Entidad> objetos_a_agregar;
	protected List<Entidad> objetos_a_eliminar;	
	
	public LogicaMapa(Juego j) {
		
		this.juego = j;
		this.barco_pirata = new Personaje();
		this.barcos_infectados = new LinkedList<Infectado>();
		
	}	
	
	public void run() {
	
		
		
	}	

}
