package viverbot.Controlador.Verificacion;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Medicion.InstrumentoMediator;

public abstract class  Transmisor implements Runnable {

	public InstrumentoMediator mediador;
	protected Magnitud valorActual;

	public Transmisor(InstrumentoMediator c) {
		this.mediador = c;
		this.valorActual = null;
	}

	@Override
	public void run() {
		Trasnmitir();
	}
	
	public InstrumentoMediator getColector() {
		return this.mediador;
	}

	protected void Trasnmitir() {

	}

	protected boolean verificarTiempo() {
		return false;
	}

	

	protected boolean realizarMedicion() {
		this.valorActual = this.mediador.tomarMedicion();
		return this.valorActual != null;
	}
}
