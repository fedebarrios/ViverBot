package com.losameos.viverbot.Controller.Medicion.Temperatura;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Sensores.SensorTemperatura;

public class ColectorTemperatura implements Runnable {
	private SensorTemperatura sensor;
	private Temperatura temperaturaActual;
	private static long frecuenciaDeRepeticion = 10000; // se expresa en
														// millisegundos
	private static long inicio = 0;

	public ColectorTemperatura() {
		this.sensor = new SensorTemperatura();
		this.temperaturaActual = null;
	}

	private void tomarMedicion() {
		setearTiempoInicio();
		medirTemperatura();
		while (true) {
			if (verificarTiempoTranscurrido()) {
				medirTemperatura();
				setearTiempoInicio();
			}
		}
	}

	private void medirTemperatura() {
		this.temperaturaActual = this.sensor.getMedicion();
	}

	private boolean verificarTiempoTranscurrido() {
		return Hora.tiempoTranscurrido(inicio) >= frecuenciaDeRepeticion;
	}

	private void setearTiempoInicio() {
		inicio = Hora.instanteActual();
	}

	public Temperatura obtenerTemperatura() {

		return this.temperaturaActual;
	}

	@Override
	public void run() {
		tomarMedicion();

	}
}
