package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.ColectorTemperatura;

public class TransmisorTemperatura extends Transmisor {

	AnalizadorTemperatura analizador;

	public TransmisorTemperatura() {
		super(new ColectorTemperatura());
		this.analizador = new AnalizadorTemperatura();
	}

	@Override
	public void run() {
		this.setearTiempoInicio();
		while (true) {
			if (this.verificarTiempoTranscurrido()) {
				realizarMedicion();
				if (this.valorActual != null) {
					this.analizador.analizar((Temperatura) this.valorActual);
					this.setearTiempoInicio();
				}

			}

		}
	}

	private void realizarMedicion() {
		this.valorActual = this.colector.tomarMedicion();
	}

}
