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
	
	/**
	 * Crea una entidad.
	 * @param movimiento Movimiento del personaje.
	 */
	public Entidad(Movimiento movimiento) {
		this.movimiento = movimiento;
		this.vida = vidaMax;
	}
	
	public void hacer() {
		this.movimiento.desplazar();
	}
	
	/**
	 * Visitor de la entidad.
	 * @param v Visitor.
	 */
	public abstract void visitar(VisitorEntidad v);
	
	public VisitorEntidad getVisitor() {
		return visitor;
	}
	
	/**
	 * Retorna la vida del personaje.
	 * @return Vida.
	 */
	public int getVida() {
		return vida;
	}
	
	/**
	 * Retorna la vida m�xima del personaje.
	 * @return Vida m�xima.
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
	 * Analiza si el personaje est� vivo.
	 * @return True si est� vivo, false en caso contrario.
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
	 * Retorna la entidad gr�fica.
	 * @return Entidad gr�fica.
	 */
	public abstract EntidadGrafica getEntidadGrafica();
}