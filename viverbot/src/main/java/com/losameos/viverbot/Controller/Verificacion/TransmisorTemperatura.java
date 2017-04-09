package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorTemperatura extends Transmisor {

	private AnalizadorTemperatura analizador;
	private static Magnitudes m = Magnitudes.TEMPERATURA;

	public TransmisorTemperatura() {
		super(new Colector(m));
		this.analizador = new AnalizadorTemperatura();
	}

	@Override
	protected void Trasnmitir() {
		this.setearTiempoInicio();
		while (true) {
			if (this.verificarTiempoTranscurrido()) {
				realizarMedicion();
				if (this.valorActual != null) {
					this.analizador.analizar((Temperatura) this.valorActual);
					this.setearTiempoInicio();
				}

			}

		}	}
	
	
	

	

}
