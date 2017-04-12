package com.losameos.viverbot.Model;

import java.util.Calendar;

public class Fecha implements Comparable{
	int dia, mes, anio;
	
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public static Fecha obtenerHoraActual() {
		Calendar calendar = Calendar.getInstance();
		int diaActual = calendar.get(Calendar.DAY_OF_MONTH);
		int mesActual = calendar.get(Calendar.MONTH);
		int anioActual = calendar.get(Calendar.YEAR);
		return new Fecha(diaActual, mesActual, anioActual);

	}

	public int getDia() {
		return dia;
	}


	public int getMes() {
		return mes;
	}


	public int getAnio() {
		return anio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}

	@Override
	public int compareTo(Object h) {
		try {
			Fecha aux = (Fecha) h;
			if (this.getAnio() == aux.getAnio()) {
				if (this.getMes() == aux.getMes()) {
					if (this.getDia() == aux.getDia()) {
						return 0;
					} else if (this.getDia() > aux.getDia()) {
						return 1;
					} else {
						return -1;
					}

				} else if (this.getMes() > aux.getMes()) {
					return 1;
				} else {
					return -1;
				}

			} else if (this.getAnio() > aux.getAnio()) {
				return 1;
			} else {
				return -1;
			}
		} catch (Exception e) {

		}
		return 0;
	}



}