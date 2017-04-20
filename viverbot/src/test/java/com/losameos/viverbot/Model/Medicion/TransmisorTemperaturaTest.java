package com.losameos.viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.Test;

import com.losameos.viverbot.Controller.Verificacion.TransmisorTemperatura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class TransmisorTemperaturaTest {

	TransmisorTemperatura trasnmisorTest = null;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertNotNull(this.trasnmisorTest.getAnalizador());
		this.clear();
	}

	@Test
	public void transmitirTemperaturaTest() {
		this.inicialize();

		Magnitud t = new Temperatura(25.0);
		Observable o = new Observable(){
			public void actuar(){
				this.setChanged();
				this.notifyObservers(t);
			}
		};
		
		o.addObserver(this.trasnmisorTest);
		
		
		Magnitud ret = this.trasnmisorTest.getAnalizador().getValorRecibido();
		System.out.println(ret);
		assertNotNull(ret);
		assertTrue(ret.getValor().equals(t));

		this.clear();
	}

	// metodos auxiliares
	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperatura();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}

}
