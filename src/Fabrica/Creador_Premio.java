package Fabrica;

import java.util.Random;

import logicaEntidades.Cuarentena_Obligatoria;
import logicaEntidades.Pocion;
import logicaEntidades.Premio;
import logicaEntidades.Super_Arma_Sanitaria;
import movimientoEntidades.Movimiento;
import movimientoEntidades.Movimiento_Premio;

/**
 * Clase que crea y retona un premio.
 */
public class Creador_Premio {
	private final int velocidadPremioPermanente = 1;
	private final int velocidadPremioTemporal = 2;
	
	/**
	 * Retorna un premio random.
	 * @param x Posicion x inicial del premio.
	 * @param y Posicion y inicial del premio.
	 * @param alturaFrame Altura del JFrame del juego.
	 * @return Premio random.
	 */
	public Premio getPremioRandom(int x,int y,int alturaFrame) {
		Random ran = new Random();
		Premio p = null;
		int valor = 0;
		valor = ran.nextInt(4);
		switch (valor) {
			case 0 : p = crearPocion(x,y,alturaFrame);
					break;
			case 1 : p = crearSuperArma(x,y,alturaFrame);
					break;
			case 2 : p = crearCuarentena(x,y,alturaFrame);
					break;
			default : p = null;
					break;
		}
		return p;
	}
	
	/**
	 * Crea un premio poción.
	 * @return poción.
	 */
	private Premio crearPocion(int x,int y,int alturaFrame) {
		Movimiento m = new Movimiento_Premio(x,y,velocidadPremioPermanente,alturaFrame);
		Pocion p = new Pocion(m);
		return p;
	}
	
	/**
	 * Crea un premio súper arma.
	 * @return súper arma.
	 */
	private Premio crearSuperArma(int x,int y,int alturaFrame) {
		Movimiento m = new Movimiento_Premio(x,y,velocidadPremioTemporal,alturaFrame);
		Super_Arma_Sanitaria sa = new Super_Arma_Sanitaria(m);
		return sa;
	}
	
	/**
	 * Crea un premio cuarentena.
	 * @return cuarentena.
	 */
	private Premio crearCuarentena(int x,int y,int alturaFrame) {
		Movimiento m = new Movimiento_Premio(x,y,velocidadPremioTemporal,alturaFrame);
		Cuarentena_Obligatoria co = new Cuarentena_Obligatoria(m);
		return co;
	}
}
