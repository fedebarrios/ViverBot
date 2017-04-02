package com.losameos.viverbot.Controller.Verificacion.Temperatura;

import com.losameos.viverbot.Controller.Medicion.Temperatura.ColectorTemperatura;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class TransmisorTemperatura implements Runnable {

	private static long frecuenciaDeRepeticion = 10000; // se expresa en
														// millisegundos
	private static long inicio = 0;

	ColectorTemperatura colector;
	AnalizadorTemperatura analizador;
	Temperatura temperaturaActual;

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
