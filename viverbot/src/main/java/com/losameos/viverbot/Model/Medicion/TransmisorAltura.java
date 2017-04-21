package com.losameos.viverbot.Model.Medicion;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class TransmisorAltura implements Observer{
	
	private AnalizadorAltura analizador;

	public TransmisorAltura() {
		this.analizador = new AnalizadorAltura();

	}

	@Override
	public void update(Observable o, Object temp) {
		this.Transmitir((ArrayList<Magnitud>) temp);
	}

	protected void Transmitir(ArrayList<Magnitud> temp) {
		this.analizador.analizar(temp);
	}

	public AnalizadorAltura getAnalizador() {
		return this.analizador;
	}
}
