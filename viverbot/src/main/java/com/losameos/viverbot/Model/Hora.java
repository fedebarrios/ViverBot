package com.losameos.viverbot.Model;

import java.util.Calendar;

public class Hora implements Comparable {
	private int hora, minuto, segundo;

	public Hora(int hora, int minuto, int segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public static Hora obtenerHoraActual() {
		Calendar calendar = Calendar.getInstance();
		int horaActual = calendar.get(Calendar.HOUR);
		int minutoActual = calendar.get(Calendar.MINUTE);
		int segundoActual = calendar.get(Calendar.SECOND);
		return new Hora(horaActual, minutoActual, segundoActual);

	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public static long instanteActual() {
		return System.currentTimeMillis();
	}

	public static long tiempoTranscurrido(long inicio) {
		return Hora.instanteActual() - inicio;
	}

	@Override
	public int compareTo(Object h) {
		try {
			Hora aux = (Hora) h;
			if (this.getHora() == aux.getHora()) {
				if (this.getMinuto() == aux.getMinuto()) {
					if (this.getSegundo() == aux.getSegundo()) {
						return 0;
					} else if (this.getSegundo() > aux.getSegundo()) {
						return 1;
					} else {
						return -1;
					}

				} else if (this.getMinuto() > aux.getMinuto()) {
					return 1;
				} else {
					return -1;
				}

			} else if (this.getHora() > aux.getHora()) {
				return 1;
			} else {
				return -1;
			}
		} catch (Exception e) {

		}
		return 0;
	}

}
