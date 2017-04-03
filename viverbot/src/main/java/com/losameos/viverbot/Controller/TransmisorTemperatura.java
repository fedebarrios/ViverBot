package com.losameos.viverbot.Controller;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Temperatura;

public class TransmisorTemperatura implements Runnable {
	private static long frecuenciaDeRepeticion = 10000; // se expresa en
														// millisegundos
	private static long inicio = 0;

	private ColectorTemperatura colector;
	private AnalizadorTemperatura analizador;
	private Temperatura temperaturaActual;

	public TransmisorTemperatura(ColectorTemperatura colector) {
		this.colector = colector;
		this.analizador = new AnalizadorTemperatura();
		temperaturaActual = null;

	}

	//////////////////////////////////////////////////////////////////////////////////////
	// revisar
	private boolean verificarTiempoTranscurrido() {
		return Hora.tiempoTranscurrido(inicio) >= frecuenciaDeRepeticion;
	}

	private void setearTiempoInicio() {
		inicio = Hora.instanteActual();
	}
	////////////////////////////////////////////////////////////////////////////////////// 77

	@Override
	public void run() {
		this.setearTiempoInicio();
		while (true) {
			if (this.verificarTiempoTranscurrido()) {
				this.temperaturaActual = this.colector.obtenerTemperatura();
				if (this.temperaturaActual != null) {
					this.analizador.analizar(this.temperaturaActual);
					this.setearTiempoInicio();
				}
			}
		}
	}

}
