package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransmisorTemperaturaTest {

	TransmisorTemperatura trasnmisorTest = null;
	Thread hilo = null;
	
	@Test
	public void transmisorTest(){
		this.inicialize();
		assertTrue(this.trasnmisorTest.getAdelanto() == 0);
		assertTrue(this.trasnmisorTest.getAnalizador() != null);
		assertTrue(this.trasnmisorTest.getFactorDeInterrupcion() == -1);
		assertTrue(this.trasnmisorTest.getFrecuenciaDeRepeticion() == 10000);
		assertTrue(this.trasnmisorTest.getInicio() == 0);
		assertTrue(this.trasnmisorTest.getRetraso() == 0);
		assertTrue(this.trasnmisorTest.getTiempoTotal() == 0);
	}

//	@Test
//	public void rasnmitirTest() {
//		this.inicialize();
//		long frecuencia = 1000;
//		int interrupcion = 10;
//		this.trasnmisorTest.setFactorDeInterrupcion(interrupcion);
//		this.trasnmisorTest.setFrecuenciaDeRepeticion(frecuencia);
//		this.hilo.start();
//		while (this.trasnmisorTest.seDebaProceguir()) {
//			System.out.print("");
//		}
//		assertTrue(this.trasnmisorTest.getAdelanto() >= 0);
//		assertTrue(this.trasnmisorTest.getRetraso() <= this.trasnmisorTest.getFrecuenciaDeRepeticion());
//
//		// Tiempo promedio
//		assertTrue((this.trasnmisorTest.getTiempoTotal() / interrupcion) < 2 * frecuencia);
//		this.hilo.interrupt();
//		clear();
//
//	}

	// metodos auxiliares
	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperatura();
		this.hilo = new Thread(this.trasnmisorTest);
	}

	private void clear() {
		// TODO Auto-generated method stub

	}

}
