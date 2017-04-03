package com.losameos.viverbot.Model;

import java.util.Calendar;

public class Hora {
	private int hora, minuto, segundo;

	public Hora(int hora, int minuto, int segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public static Hora obtenerHoraActual()
	{
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
		// TODO Auto-generated method stub
		return Hora.instanteActual() - inicio;
	}

}
