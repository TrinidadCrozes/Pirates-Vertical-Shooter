import logicaJuego.Juego;
import movimientoEntidades.*;

/**
 * Clase que modela un enemigo.
 */
public abstract class Infectado extends Personaje{
	protected int damageFisico;
	
	/**
	 * Constructor del infectado.
	 * @param movimiento Movimiento del infectado.
	 * @param juego Juego.
	 */
	public Infectado(Movimiento movimiento,Juego juego) {
		super(movimiento,juego);
	}
	
	/**
	 * Retorna la cantidad de vida que le quita al jugador al hacer contacto.
	 * @return cantidad de vida que quita.
	 */
	public int getDamageFisico() {
		return damageFisico;
	}
	
	@Override
	public void detener() {
		Movimiento_Enemigo mov = new Movimiento_Enemigo_Detenido((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY(),this.movimiento.getAlturaFrame());
		this.setMovimiento(mov);
	}
	
	@Override
	public void mover() {
		Movimiento_Enemigo mov = new Movimiento_Enemigo((int)this.movimiento.getPosicion().getX(),(int)this.movimiento.getPosicion().getY(),this.movimiento.getAlturaFrame());
		this.setMovimiento(mov);
	}
	
	@Override
	public void morir() {
		this.juego.decrementarCantEnemigos();
	}
}
