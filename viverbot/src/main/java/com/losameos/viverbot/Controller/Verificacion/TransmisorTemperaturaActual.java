package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.Colector;

public class TransmisorTemperaturaActual extends Transmisor {

	private AnalizadorTemperatura analizador;
	private static Magnitudes m = Magnitudes.TEMPERATURA;
	private long inicio = 0;

	private long frecuenciaDeRepeticion = 10000; // se expresa en milisegundos
	//private int factorDeInterrupcion;

	// millisegundos

	public TransmisorTemperaturaActual() {
		super(new Colector(m));
		this.analizador = new AnalizadorTemperatura();
		//this.factorDeInterrupcion = -1;
	}

	@Override
	protected void Trasnmitir() {	
				enviarDato();
	}

	


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

	public Double getValorTemperatura(){
		return colector.getInstrumentoMedicion().getMedicion().getValor();
	}
}

