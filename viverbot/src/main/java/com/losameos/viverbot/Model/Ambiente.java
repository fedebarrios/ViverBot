package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class Ambiente implements Runnable {

	private static Temperatura temperaturaActual = new Temperatura(25.0);;
	private Hora horaActual;
	private static Ambiente ambiente;

	public static Ambiente getInstance() {
		if (ambiente == null) {
			ambiente = new Ambiente();
		}
		return ambiente;
	}

	@Override
	public void run() {

	}

	public Temperatura getTemperatura() {
		return temperaturaActual;

	}

	public void setHoraActual(Hora hora) {
		horaActual = hora;
	}

	public void setTemperatura(Temperatura t) {
		temperaturaActual = t;
	}

}
