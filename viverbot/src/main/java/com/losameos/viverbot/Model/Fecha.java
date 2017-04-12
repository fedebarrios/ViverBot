package com.losameos.viverbot.Model;

import java.util.Calendar;
import java.util.Date;

public class Fecha implements Comparable{
	int dia, mes, anio;
	
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public static Fecha obtenerFechaActual() {
		Calendar calendar = Calendar.getInstance();
		int diaActual = calendar.get(Calendar.DAY_OF_MONTH);
		int mesActual = calendar.get(Calendar.MONTH);
		int anioActual = calendar.get(Calendar.YEAR);
		return new Fecha(diaActual, mesActual+1, anioActual);

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
	
	@SuppressWarnings("deprecation")
	public static int diasEntreDosFechas(Fecha fechaActual, Fecha fechaPasada){
		final long milisegundosPorDia = 24 * 60 * 60 * 1000;
		Date dateActual = new Date(fechaActual.anio,fechaActual.mes,fechaActual.dia); 	
		Date datePasado = new Date(fechaPasada.anio,fechaPasada.mes,fechaPasada.dia);
		long days = ( dateActual.getTime() - datePasado.getTime() ) / milisegundosPorDia;
        return (int) days;
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
