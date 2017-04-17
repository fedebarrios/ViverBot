package com.losameos.viverbot.Controller.Verificacion;

import java.util.Observable;
import java.util.Observer;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class TransmisorTemperatura implements Observer{

	private AnalizadorTemperatura analizador;

	public TransmisorTemperatura(){
		this.analizador = new AnalizadorTemperatura();

	}
	@Override
	public void update(Observable o, Object temp) {
		this.Transmitir((Temperatura)temp);
	}
	
	private void Transmitir(Temperatura temp){
		this.analizador.analizar((Temperatura)temp);

	}

	public AnalizadorTemperatura getAnalizador() {
		return analizador;
	}

	public void setAnalizador(AnalizadorTemperatura analizador) {
		this.analizador = analizador;
	}
}
