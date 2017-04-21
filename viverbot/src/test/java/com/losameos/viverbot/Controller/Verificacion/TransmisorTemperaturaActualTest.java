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
<<<<<<< HEAD
		assertTrue(this.trasnmisorTest.getValorTemperatura() != null);
=======
		assertTrue(this.trasnmisorTest.getAnalizador() != null);
>>>>>>> origin/master

		this.clear();
	}

<<<<<<< HEAD
=======
	@Test
	public void resetTest() {
		this.inicialize();
		//this.trasnmisorTest.reset();
		this.clear();

	}
>>>>>>> origin/master

	@Test
	public void enviarDatoTest() {
		this.inicialize();
<<<<<<< HEAD

		Ambiente a = Ambiente.getInstance();
		Temperatura t = a.getTemperatura();
		
		this.trasnmisorTest.enviarDato();
		Temperatura e=this.trasnmisorTest.getValorTemperatura();
=======
		Temperatura t = new Temperatura(20.0);
		Ambiente a = Ambiente.getInstance();
		a.setTemperatura(t);
		this.trasnmisorTest.enviarDato();
		
		Temperatura e=new Temperatura(this.trasnmisorTest.colector.getInstrumentoMedicion().getMedicion().getValor());
		assertTrue(e != null);
>>>>>>> origin/master
		assertTrue(e.equals(t));
		this.clear();
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> origin/master

	// metodos auxiliares
	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperaturaActual();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}

}
