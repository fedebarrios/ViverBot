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

		Magnitud valorActual = this.medir();
		this.setChanged();
		this.notifyObservers(valorActual);

	}

	private Magnitud medir() {
		return this.mediator.tomarMedicion();
	}

}
