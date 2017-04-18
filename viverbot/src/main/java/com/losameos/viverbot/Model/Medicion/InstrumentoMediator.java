package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Sensores.InstrumentoFactory;
import com.losameos.viverbot.Model.Sensores.InstrumentoMedicion;

public class InstrumentoMediator {
	protected InstrumentoMedicion instrumentoMedicion;
	protected String tipoValor;

	public InstrumentoMediator() {
		this.tipoValor = "";
	}

	public InstrumentoMediator(Magnitudes m) {
		this.instrumentoMedicion = InstrumentoFactory.crearInstrumento(m);
	}

	public Magnitud tomarMedicion() {
		return this.instrumentoMedicion.getMedicion();
	}

	public InstrumentoMedicion getInstrumentoMedicion() {
		return instrumentoMedicion;
	}

}
