package com.losameos.viverbot.Model.Medicion;

import java.util.Observable;
import java.util.Observer;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class TransmisorTemperatura implements Observer {

	private AnalizadorTemperatura analizador;

	public TransmisorTemperatura() {
		this.analizador = new AnalizadorTemperatura();

	}

	@Override
	public void update(Observable o, Object temp) {
		this.Transmitir((Magnitud) temp);
	}

	protected void Transmitir(Magnitud temp) {
		this.analizador.analizar(temp);

	}

	

	public AnalizadorTemperatura getAnalizador() {
		return this.analizador;
	}
}
