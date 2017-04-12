package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorTemperaturaActual extends Transmisor {

	private AnalizadorTemperatura analizador;
	private static Magnitudes m = Magnitudes.TEMPERATURA;
	private long inicio = 0;
	private long retraso = 0;
	private long adelanto = 0;
	private long tiempoTotal = 0;
	private long tiempoInicio = 0;

	private long frecuenciaDeRepeticion = 10000; // se expresa en milisegundos
	private int factorDeInterrupcion;

	// millisegundos

	public TransmisorTemperaturaActual() {
		super(new Colector(m));
		this.analizador = new AnalizadorTemperatura();
		this.factorDeInterrupcion = -1;
	}

	@Override
	protected void Trasnmitir() {
		//this.reset();
//		this.setearTiempoInicio();
//		this.tiempoInicio = inicio;
//		while (seDebaProceguir()) {
//			if (this.verificarTiempo()) {
		
				enviarDato();

				//				this.factorDeInterrupcion--;
//				this.calcularRetraso();
//				this.setearTiempoInicio();

//			}
//		}
//		this.tiempoTotal = Hora.instanteActual()  - this.tiempoInicio;
	}

/*	protected void reset() {
		this.inicio = 0;
		this.adelanto = 0;
		this.retraso = 0;
		this.tiempoTotal = 0;
		this.tiempoInicio = 0;
	}
*/
	/*private void calcularRetraso() {
		if (inicio > 0) {
			long resta = Hora.instanteActual() - inicio - frecuenciaDeRepeticion;
			if (resta >= 0) {
				if (this.retraso < resta) {
					this.retraso = resta;
				}
			}
			if (resta < 0) {
				if (this.adelanto > resta) {
					this.adelanto = resta;
				}
			}
		}

	}*/

/*	protected boolean seDebaProceguir() {
		if (this.factorDeInterrupcion == 0) {
			return false;
		}
		return true;
	}
*/
	protected boolean enviarDato() {

		if (realizarMedicion()) {
			this.analizador.analizar((Temperatura) this.valorActual);
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

	/*public long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public long getFrecuenciaDeRepeticion() {
		return frecuenciaDeRepeticion;
	}

	public void setFrecuenciaDeRepeticion(long f) {
		this.frecuenciaDeRepeticion = f;
	}

	public int getFactorDeInterrupcion() {
		return factorDeInterrupcion;
	}

	public void setFactorDeInterrupcion(int factorDeInterrupcion) {
		this.factorDeInterrupcion = factorDeInterrupcion;
	}

	public long getRetraso() {
		return retraso;
	}

	public long getAdelanto() {
		return adelanto;
	}

	public long getTiempoTotal() {
		return tiempoTotal;
	}
	
	public long getTiempoInicial() {
		return this.tiempoInicio;
	}
*/
}

