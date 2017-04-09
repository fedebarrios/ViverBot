package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorTemperatura extends Transmisor {

	private AnalizadorTemperatura analizador;
	private static Magnitudes m = Magnitudes.TEMPERATURA;
	private static long inicio = 0;
	private static long frecuenciaDeRepeticion = 1000; // se expresa en
	// millisegundos

	public TransmisorTemperatura() {
		super(new Colector(m));
		this.analizador = new AnalizadorTemperatura();
	}

	@Override
	protected void Trasnmitir() {
		this.setearTiempoInicio();
		while (true) {

			if (this.verificarTiempo()) {

				realizarMedicion();

				if (this.valorActual != null) {
					this.analizador.analizar((Temperatura) this.valorActual);
					this.setearTiempoInicio();
				}

			}

		}
	}

	@Override
	protected boolean verificarTiempo() {

		return Hora.tiempoTranscurrido(inicio) >= frecuenciaDeRepeticion;

	}

	protected void setearTiempoInicio() {
		inicio = Hora.instanteActual();
	}

}
