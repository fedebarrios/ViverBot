package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.InstrumentoMediator;

public class ColectorTemperatura extends Automatizador {

	protected InstrumentoMediator mediator;
	private final static Magnitudes m = Magnitudes.TEMPERATURA;

	public ColectorTemperatura() {
		mediator = new InstrumentoMediator(m);
	}

	@Override
	protected void realizarTarea() {

		Magnitud valorActual = this.realizarMedicion();
		this.setChanged();
		this.notifyObservers(valorActual);

	}

	private Magnitud realizarMedicion() {
		return this.mediator.tomarMedicion();
	}

}
