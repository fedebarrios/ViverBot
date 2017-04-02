package com.losameos.viverbot.Controller.Medicion.Temperatura;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Sensores.SensorTemperatura;

public class ColectorTemperatura extends Thread {
	SensorTemperatura sensor;
	Temperatura temperaturaActual;
	private static long frecuenciaDeRepeticion = 10000; // se expresa en
														// millisegundos
	private static long inicio = 0;

	public ColectorTemperatura() {
		this.sensor = new SensorTemperatura();
		this.temperaturaActual = null;
	}

	public void run() {
		tomarMedicion();
	}

	private void tomarMedicion() {
		setearTiempoInicio();

		while (true) {
			if (verificarTiempoTranscurrido()) {
				this.temperaturaActual = this.sensor.getMedicion();
				setearTiempoInicio();
			}
		}
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
}
