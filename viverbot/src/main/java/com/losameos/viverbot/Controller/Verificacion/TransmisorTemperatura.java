package com.losameos.viverbot.Controller.Verificacion;

import java.util.Observable;
import java.util.Observer;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Medicion.AnalizadorTemperatura;

public class TransmisorTemperatura implements Observer {

	private AnalizadorTemperatura analizador;

	public TransmisorTemperatura() {
		this.analizador = new AnalizadorTemperatura();

	}

	@Override
	public void update(Observable o, Object temp) {
		this.Transmitir((Magnitud) temp);
	}

	private void Transmitir(Magnitud temp) {
		this.analizador.analizar(temp);

	}

	public void setAnalizador(AnalizadorTemperatura analizador) {
		this.analizador = analizador;
	}

	public AnalizadorTemperatura getAnalizador() {
		// TODO Auto-generated method stub
		return this.analizador;
	}
}
