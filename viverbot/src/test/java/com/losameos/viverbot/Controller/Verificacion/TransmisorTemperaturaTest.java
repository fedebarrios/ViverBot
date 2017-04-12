package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class TransmisorTemperaturaTest {

	TransmisorTemperatura trasnmisorTest = null;
	Thread hilo = null;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertTrue(this.trasnmisorTest.getAdelanto() == 0);
		assertTrue(this.trasnmisorTest.getAnalizador() != null);
		assertTrue(this.trasnmisorTest.getFactorDeInterrupcion() == -1);
		assertTrue(this.trasnmisorTest.getFrecuenciaDeRepeticion() == 5000);
		assertTrue(this.trasnmisorTest.getInicio() == 0);
		assertTrue(this.trasnmisorTest.getRetraso() == 0);
		assertTrue(this.trasnmisorTest.getTiempoTotal() == 0);
		assertTrue(this.trasnmisorTest.getTiempoInicial() == 0);
		this.clear();
	}

	@Test
	public void resetTest() {
		this.inicialize();
		this.trasnmisorTest.reset();
		assertTrue(this.trasnmisorTest.getRetraso() == 0);
		assertTrue(this.trasnmisorTest.getTiempoTotal() == 0);
		assertTrue(this.trasnmisorTest.getInicio() == 0);
		assertTrue(this.trasnmisorTest.getAdelanto() == 0);
		assertTrue(this.trasnmisorTest.getTiempoInicial() == 0);
		this.clear();

	}

	@Test
	public void seDebeProceguirTest() {
		this.inicialize();
		long frecuencia = 1000;
		int interrupcion = 1;
		setearTransmisor(frecuencia, interrupcion);
		this.hilo.start();
		this.esperarHilo(this.hilo);

		assertTrue(this.trasnmisorTest.getFactorDeInterrupcion() == 0);
		assertFalse(this.trasnmisorTest.seDebaProceguir());
		this.hilo.interrupt();
		this.clear();
	}

	@Test
	public void enviarDatoTest() {
		this.inicialize();
		Temperatura t = new Temperatura(20.0);
		Ambiente a = Ambiente.getInstance();
		a.setTemperatura(t);
		this.trasnmisorTest.enviarDato();
		EstadoTemperatura e = this.trasnmisorTest.getAnalizador().getEstado();
		assertTrue(e != null);
		assertTrue(e.getTemperatura().equals(t));
		this.clear();
	}
	
	@Test
	public void verificarTiempoTrueTest(){
		this.inicialize();
		long frecuencia = 1000;
		long inicio = 1000000000;
		long fin =133045820;
		this.trasnmisorTest.setFrecuenciaDeRepeticion(frecuencia);
		this.trasnmisorTest.setInicio(inicio);
		assertTrue(this.trasnmisorTest.verificarTiempo());
		this.clear();
		
		
	}
	
	@Test
	public void verificarTiempoFalseTest(){
		this.inicialize();
		long frecuencia = 1000;
		long inicio = 1000000000;
		long fin =133045820;
		this.trasnmisorTest.setFrecuenciaDeRepeticion(frecuencia);
		this.trasnmisorTest.setInicio(inicio);
		assertTrue(this.trasnmisorTest.verificarTiempo());
		this.clear();
	}

	// @Test
	// public void rasnmitirTest() {
	// this.inicialize();
	// long frecuencia = 1000;
	// int interrupcion = 10;
	// this.trasnmisorTest.setFactorDeInterrupcion(interrupcion);
	// this.trasnmisorTest.setFrecuenciaDeRepeticion(frecuencia);
	// this.hilo.start();
	// while (this.trasnmisorTest.seDebaProceguir()) {
	// System.out.print("");
	// }
	// assertTrue(this.trasnmisorTest.getAdelanto() >= 0);
	// assertTrue(this.trasnmisorTest.getRetraso() <=
	// this.trasnmisorTest.getFrecuenciaDeRepeticion());
	//
	// // Tiempo promedio
	// assertTrue((this.trasnmisorTest.getTiempoTotal() / interrupcion) < 2 *
	// frecuencia);
	// this.hilo.interrupt();
	// clear();
	//
	// }

	// metodos auxiliares
	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperatura();
		this.hilo = new Thread(this.trasnmisorTest);
	}

	private void clear() {
		this.trasnmisorTest = null;
		this.hilo = null;
	}

	private void setearTransmisor(long frecuencia, int interrupcion) {
		this.trasnmisorTest.setFactorDeInterrupcion(interrupcion);
		this.trasnmisorTest.setFrecuenciaDeRepeticion(frecuencia);
	}

	private void esperarHilo(Thread hilo2) {
		while (this.trasnmisorTest.seDebaProceguir()) {
			System.out.print("");
		}
	}

}
