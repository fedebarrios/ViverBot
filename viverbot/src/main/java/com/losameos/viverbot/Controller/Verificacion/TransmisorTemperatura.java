package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorTemperatura extends Transmisor {

	private AnalizadorTemperatura analizador;
	private static Magnitudes m = Magnitudes.TEMPERATURA;
	private static long inicio = 0;
	private static long frecuenciaDeRepeticion = 1000; // se expresa en
	private int factorDeInterrupcion;
	
	// millisegundos

	public TransmisorTemperatura() {
		super(new Colector(m));
		this.analizador = new AnalizadorTemperatura();
		this.factorDeInterrupcion = -1;
	}

	@Override
	protected void Trasnmitir() {
		this.setearTiempoInicio();
		while (seDebaProceguir()) {
			if (this.verificarTiempo()) {
				enviarDato();
				this.factorDeInterrupcion--;

			}
		}
	}

	protected boolean seDebaProceguir() {
		if (this.factorDeInterrupcion == 0) {
			return false;
		}
		return true;
	}

	private boolean enviarDato() {

		if (realizarMedicion()) {
			this.analizador.analizar((Temperatura) this.valorActual);
			this.setearTiempoInicio();
			return true;
		} else {
			// aqui se debe la acoplar la logica de alarmas o bien el
			// soporte que pueda brindar el
			// sistema ante fallas en la medicion, los cuales aun no se han
			// definido ni planificado
			return false;
		}

	}

	@Override
	protected boolean verificarTiempo() {

		return Hora.tiempoTranscurrido(inicio) >= frecuenciaDeRepeticion;

	}

	protected void setearTiempoInicio() {
		inicio = Hora.instanteActual();
	}

	public AnalizadorTemperatura getAnalizador() {
		return analizador;
	}

	public void setAnalizador(AnalizadorTemperatura analizador) {
		this.analizador = analizador;
	}

	public static long getInicio() {
		return inicio;
	}

	public static void setInicio(long inicio) {
		TransmisorTemperatura.inicio = inicio;
	}

	public static long getFrecuenciaDeRepeticion() {
		return frecuenciaDeRepeticion;
	}

	public static void setFrecuenciaDeRepeticion(long frecuenciaDeRepeticion) {
		TransmisorTemperatura.frecuenciaDeRepeticion = frecuenciaDeRepeticion;
	}

	public int getFactorDeInterrupcion() {
		return factorDeInterrupcion;
	}

	public void setFactorDeInterrupcion(int factorDeInterrupcion) {
		this.factorDeInterrupcion = factorDeInterrupcion;
	}

}
