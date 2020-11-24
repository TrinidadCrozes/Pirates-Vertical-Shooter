package Fabrica;

import java.awt.Point;
import java.util.Random;

import logicaEntidades.Infectado;
import logicaEntidades.Infectado_Beta;
import logicaEntidades.Proyectil_Infectado;
import logicaJuego.Juego;
import movimientoEntidades.Movimiento_Enemigo;

public class FabricaBeta extends FabricaInfectado {

	protected Movimiento_Enemigo movimiento;
	protected Proyectil_Infectado proyectil;

	public FabricaBeta(Juego juego) {
			super(juego);
		}

	@Override
	public Infectado crearInfectado(int anchoJFrame, int altoJFrame) { 
		Random rnd = new Random(0);
		int pos_x = rnd.nextInt(anchoJFrame); 
		Point ubicacion = new Point(pos_x, 0);
		this.movimiento = new Movimiento_Enemigo(ubicacion.x, ubicacion.y, 1, altoJFrame);
		
		return new Infectado_Beta(movimiento); 
	}

}
