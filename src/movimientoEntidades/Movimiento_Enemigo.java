package movimientoEntidades;

import java.util.Random;



import logicaEntidades.Cuarentena_Obligatoria;
import logicaEntidades.Pocion;
import logicaEntidades.Premio;
import logicaEntidades.Proyectil;
import logicaEntidades.Proyectil_Infectado;
import logicaEntidades.Super_Arma_Sanitaria;


/**
 * Clase que modela al movimiento de un enemigo.
 */
public class Movimiento_Enemigo extends Movimiento {
	protected boolean detenido = false;
	
	/**
	 * Constructor del movimiento de un enemigo, se inicializa con la posición inicial del mismo.
	 * @param x Coordenada x inicial de la entidad.
	 * @param y Coordenada y inicial de la entidad.
	 * @param velocidad Velocidad de movimiento de la entidad.
	 * @param alturaFrame La altura del frame del juego.
	 */
	public Movimiento_Enemigo(int x, int y,int velocidad,int alturaFrame) {
		super(x, y, velocidad, alturaFrame);
	}
	
	/**
	 * Crea un proyectil enemigo.
	 * @return proyectil enemigo.
	 */
	public Proyectil atacar() {
		Movimiento m = new Movimiento_Proyectil_Enemigo(this.posicion.x,this.posicion.y,this.velocidad + 1,this.alturaFrame);
		Proyectil_Infectado p = new Proyectil_Infectado(m);
		return p;
	}
	
	/**
	 * Lanza un premio.
	 * @return premio.
	 */
	public Premio lanzarPremio() {
		Random ran = new Random();
		int valor = ran.nextInt(2);
		Premio p = null;
		if(valor == 1) {
			valor = ran.nextInt(3);
			switch (valor) {
				case 0 : p = crearPocion();
						break;
				case 1 : p = crearSuperArma();
						break;
				case 2 : p = crearCuarentena();
						break;
			}
		}
		return p;
	}
	
	/**
	 * Crea un premio poción.
	 * @return poción.
	 */
	private Premio crearPocion() {
		Movimiento m = new Movimiento_Premio(this.posicion.x,this.posicion.y,1,this.alturaFrame);
		Pocion p = new Pocion(m);
		return p;
	}
	
	/**
	 * Crea un premio súper arma.
	 * @return súper arma.
	 */
	private Premio crearSuperArma() {
		Movimiento m = new Movimiento_Premio(this.posicion.x,this.posicion.y,2,this.alturaFrame);
		Super_Arma_Sanitaria sa = new Super_Arma_Sanitaria(m);
		return sa;
	}
	
	/**
	 * Crea un premio cuarentena.
	 * @return cuarentena.
	 */
	private Premio crearCuarentena() {
		Movimiento m = new Movimiento_Premio(this.posicion.x,this.posicion.y,2,this.alturaFrame);
		Cuarentena_Obligatoria co = new Cuarentena_Obligatoria(m);
		return co;
	}
	
	@Override
	public void desplazar() {
		if(!detenido) {
			this.posicion.setLocation(this.posicion.x,this.posicion.y + velocidad);
			if(this.posicion.y == alturaFrame) {
				this.posicion.setLocation(this.posicion.x,0);
			}
		}
	}

	@Override
	public void moverDerecha() {
		//No se mueve hacia la derecha.
	}

	@Override
	public void moverIzquierda() {
		//No se mueve hacia la izquierda.
	}

	@Override
	public boolean puedeMoverse() {
		return !detenido;
	}
	
	public void detener() {
		detenido = true;
	}

	public void mover() {
		detenido = false;
	}
}

