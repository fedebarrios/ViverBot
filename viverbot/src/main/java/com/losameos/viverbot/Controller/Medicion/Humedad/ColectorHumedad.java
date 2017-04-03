package com.losameos.viverbot.Controller.Medicion.Humedad;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Sensores.SensorHumedad;

//estas clase tiene mucho codigo repetido  seguramente tenga que usar herencia
public class ColectorHumedad implements Runnable {
	private SensorHumedad sensor;
	private Humedad humedadActual;
	private static long frecuenciaDeRepeticion = 10000; // se expresa en
	private static long inicio = 0; // millisegundos

	public ColectorHumedad() {
		this.sensor = new SensorHumedad();
		this.humedadActual = null;

	}

	@Override
	public void run() {
		tomarMedicion();
	}

	private void tomarMedicion() {
		setearTiempoInicio();
		medirHumedad();
		while (true) {
			if (verificarTiempoTranscurrido()) {
				medirHumedad();
				setearTiempoInicio();
				System.out.println("la humedad es: " + this.humedadActual.getValor() );
			}
		}
	}

	private boolean verificarTiempoTranscurrido() {
		return Hora.tiempoTranscurrido(inicio) >= frecuenciaDeRepeticion;

	}

	private void medirHumedad() {
		this.humedadActual = this.sensor.getMedicion();
	}

	private void setearTiempoInicio() {
		inicio = Hora.instanteActual();

	}

}
