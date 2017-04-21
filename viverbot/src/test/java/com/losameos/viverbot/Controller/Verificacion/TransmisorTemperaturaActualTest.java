package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class TransmisorTemperaturaActualTest {

	TransmisorTemperaturaActual trasnmisorTest = null;
	Thread hilo = null;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertTrue(this.trasnmisorTest.getValorTemperatura() != null);

		this.clear();
	}


	@Test
	public void enviarDatoTest() {
		this.inicialize();

		Temperatura t = new Temperatura(20.0);
		Ambiente a = Ambiente.getInstance();
		a.setTemperatura(t);
		
		Temperatura e=new Temperatura(this.trasnmisorTest.mediador.getInstrumentoMedicion().getMedicion().getValor());
		assertTrue(e.equals(t));
		this.clear();
	}
	

	// metodos auxiliares
	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperaturaActual();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}

}
