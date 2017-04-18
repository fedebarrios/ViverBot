package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Medicion.InstrumentoMediator;

public abstract class  Transmisor implements Runnable {

	protected InstrumentoMediator colector;
	protected Magnitud valorActual;

	public Transmisor(InstrumentoMediator c) {
		this.colector = c;
		this.valorActual = null;
	}

	@Override
	public void run() {
		Trasnmitir();
	}
	
	public InstrumentoMediator getColector() {
		return this.colector;
	}

	protected void Trasnmitir() {

	}

	protected boolean verificarTiempo() {
		return false;
	}

	

	protected boolean realizarMedicion() {
		this.valorActual = this.colector.tomarMedicion();
		return this.valorActual != null;
	}
}
