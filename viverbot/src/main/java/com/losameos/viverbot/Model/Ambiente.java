package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class Ambiente implements Runnable {

	private static Temperatura temperaturaActual = new Temperatura(25.0);;
	private Hora horaActual;

	@Override
	public void run() {

	}

	public static Temperatura getTemperatura() {
		return temperaturaActual;

	}

	public void setHoraActual(Hora hora) {
		horaActual = hora;
	}

	public void setTemperatura(double d) {
		temperaturaActual = new Temperatura(d);
	}

}
