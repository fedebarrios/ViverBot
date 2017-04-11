package com.losameos.viverbot.Model.Sensores;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class IntrumentoFactoryTest {

	private static InstrumentoMedicion ins = null;

	@Test
	public void CreatInstrumentoTestTemperatura() {
		ins = InstrumentoFactory.crearInstrumento(Magnitudes.TEMPERATURA);
		assertTrue(ins instanceof SensorTemperatura);
		clear();
	}

	@Test
	public void CreatInstrumentoTestHumedad() {
		ins = InstrumentoFactory.crearInstrumento(Magnitudes.HUMEDAD);
		assertTrue(ins instanceof SensorHumedad);
		this.clear();
	}
	
	@Test
	public void CreatInstrumentoTestAltura() {
		ins = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		assertTrue(ins instanceof Metro);
		this.clear();
	}

	@Test
	public void CreatSingletownTestTemperatura() {
		ins = InstrumentoFactory.crearInstrumento(Magnitudes.TEMPERATURA);
		InstrumentoMedicion aux = InstrumentoFactory.crearInstrumento(Magnitudes.TEMPERATURA);
		assertTrue(ins == aux);
		this.clear();
	}
	
	@Test
	public void CreatSingletownTestHumedad() {
		ins = InstrumentoFactory.crearInstrumento(Magnitudes.HUMEDAD);
		InstrumentoMedicion aux = InstrumentoFactory.crearInstrumento(Magnitudes.HUMEDAD);
		assertTrue(ins == aux);
		this.clear();
	}
	
	@Test
	public void CreatSingletownTestAltura() {
		ins = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		InstrumentoMedicion aux = InstrumentoFactory.crearInstrumento(Magnitudes.ALTURA);
		assertTrue(ins == aux);
		this.clear();
	}

	// metodos auxiliares
	private void clear() {
		ins = null;
	}

}
