package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Sensores.InstrumentoMedicion;

public class Colector {
	protected InstrumentoMedicion instrumentoMedicion;
	protected Magnitud valorActual;
	protected String tipoValor;
	
	public Colector() {
		this.valorActual = null;
		this.tipoValor = "";
	}

	public Colector(InstrumentoMedicion s) {
		this.instrumentoMedicion = s;
		this.valorActual = null;
	}

	public Magnitud tomarMedicion() {
		this.medir();
		return this.valorActual;
	}

	protected void medir() {
		this.valorActual = this.instrumentoMedicion.getMedicion();
	}

}
