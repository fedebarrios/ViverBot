package com.losameos.viverbot.Controller.Verificacion;


import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Medicion.Colector;

public class Transmisor implements Runnable {

	private static long frecuenciaDeRepeticion = 1000; // se expresa en
	// millisegundos
	private static long inicio = 0;

	protected Colector colector;
	protected Magnitud valorActual;
	
	public Transmisor(Colector c){
		this.colector = c;
		this.valorActual = null;
	}

	@Override
	public void run() {

	}
	
	protected boolean verificarTiempoTranscurrido() {
		return Hora.tiempoTranscurrido(inicio) >= frecuenciaDeRepeticion;
	}

	protected void setearTiempoInicio() {
		inicio = Hora.instanteActual();
	}

	protected void realizarMedicion() {
		this.valorActual = this.colector.tomarMedicion();
	}
}
