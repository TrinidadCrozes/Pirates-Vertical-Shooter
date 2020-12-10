package logicaEntidades; 
import visitor.*;
import graficaEntidades.EntidadGrafica;
import movimientoEntidades.*;

/**
 * Clase que modela una entidad.
 */
public abstract class Entidad {
	protected Movimiento movimiento;
	protected int vida;
	protected final int vidaMax = 100;
	protected VisitorEntidad visitor;
	protected EntidadGrafica grafica;
	
	/**
	 * Crea una entidad.
	 * @param movimiento Movimiento del personaje.
	 */
	public Entidad(Movimiento movimiento) {
		this.movimiento = movimiento;
		this.vida = vidaMax;
	}
	
	/**
	 * Visitor de la entidad.
	 * @param v Visitor.
	 */
	public abstract void visitar(VisitorEntidad v);
	
	/**
	 * Revisa si la entidad se encuentra en estado crítico, y en caso de estarlo modifica su movimiento y apariencia.
	 */
	public abstract void estadoCritico();
	
	/**
	 * Indica que la entidad no esta más en juego.
	 */
	public abstract void morir();
	
	/**
	 * Detiene a la entidad.
	 */
	public abstract void detener();
	
	/**
	 * Desplaza a la entidad.
	 */
	public abstract void mover();
	
	/**
	 * Retorna la vida del personaje.
	 * @return Vida.
	 */
	public int getVida() {
		return vida;
	}
	
	/**
	 * Retorna la vida máxima del personaje.
	 * @return Vida máxima.
	 */
	public int getVidaMax() {
		return vidaMax;
	}
	
	/**
	 * Resta al personaje la vida indicada.
	 * @param v Vida a restar.
	 */
	public void quitarVida(int v) {
		this.vida = this.vida - v;
		if(this.vida < 0) {
			this.vida = 0;
		}
	}
	
	/**
	 * Analiza si el personaje está vivo.
	 * @return True si está vivo, false en caso contrario.
	 */
	public boolean estaVivo() {
		return vida > 0;
	}

	/**
	 * Retorna el movimiento de la entidad.
	 * @return movimiento.
	 */
	public Movimiento getMovimiento() {
		return movimiento;
	}
	
	/**
	 * Obtiene el movimiento de la entidad.
	 * @param movimiento.
	 */
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
	/**
	 * Retorna la entidad gráfica.
	 * @return Entidad gráfica.
	 */
	public EntidadGrafica getEntidadGrafica() {
		return grafica;
	}
	
	/**
	 * Modifica la entidad grafica de la entidad por la pasada como parametro.
	 * @param g Entidad grafica.
	 */
	public void setEntidadGrafica(EntidadGrafica g) {
		this.grafica = g;
	}
	
	/**
	 * Retorna el visitor de la entidad.
	 * @return Visitor.
	 */
	public VisitorEntidad getVisitor() {
		return this.visitor;
	}
	
	/**
	 * Avisa a la entidad que debe disparar.
	 * @return Proyectil.
	 */
	public Proyectil disparar() {
		return this.movimiento.atacar();
	}
}
