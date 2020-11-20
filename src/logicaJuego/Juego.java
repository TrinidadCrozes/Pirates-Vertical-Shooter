package logicaJuego;

import java.util.LinkedList;
import java.util.List;

import graficaEntidades.EntidadGrafica;
import logicaEntidades.Entidad;
import logicaEntidades.Jugador;
import movimientoEntidades.Movimiento;
import visitor.*;

//El nivel se tendria que encargar de agregar a la lista a recorrer a los enemigos
public class Juego {
	protected GUI.Juego gui;
	protected List<Entidad> entidadesLista;

	protected Jugador jugador;
	protected Movimiento movimiento;
	protected EntidadGrafica grafica;
	protected VisitorJugador visitor;
	
	public Juego() {
		entidadesLista = new LinkedList<Entidad>();
		//Lo primero seria crear el personaje principal, (ACOMODAR PARAMETROS)
		jugador = new Jugador(null, null, null, null);
		entidadesLista.add(jugador);
		
		//Aca pondriamos que empieza desde el nivel 1 por ejemplo y 
		//configuraciones de como tiene que arrancar el mapa, personajes, etc
		
	}
	
	
	
	//Recorreria toda la lista de entidades y le indicaria a cada uno 
	//lo que tiene que hacer
	public void actualizar() {
		for (Entidad e: entidadesLista) {
			 //e.accionar(); cada entidad sabe como actuar
			
			//Si esta muerto, lo saco de la lista para que no lo vuelva a accionar
			if (e.obtenerVida() <= 0) {
				entidadesLista.remove(e);
			}
			
			
		}
		
		
	}
	
	
}
