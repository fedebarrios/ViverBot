package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Medicion.Colector;

public class Transmisor implements Runnable {

	protected Colector colector;
	protected Magnitud valorActual;

	public Transmisor(Colector c) {
		this.colector = c;
		this.valorActual = null;
	}

	@Override
	public void run() {
		Trasnmitir();
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
