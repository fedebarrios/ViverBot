package com.losameos.viverbot.Model.Medicion;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Hora;

public class ColectorTemperaturaTest {
	ColectorTemperatura colector = null;

	@Test
	public void testColectorTemperatura() {
		this.inicialize();
		assertNotNull(this.colector.getMediator());
		assertNotNull(this.colector.getFrecuencia());
		assertNotNull(this.colector.getDelay());
		assertNotNull(this.colector.getTimer());
		assertNull(this.colector.getValorActual());
		this.clear();
	}

	@Test
	public void testColectar() throws InterruptedException {
		this.inicialize();
		this.colector.colectar();
		this.esperar(this.colector.getFrecuencia());
		assertNotNull(this.colector.getValorActual());

		this.clear();
	}

	@Test
	public void testMedir() {
		this.inicialize();
		assertTrue(this.verificarTemperatura(this.getHorarios(), Ambiente.getInstance()));
		this.clear();

	}

	// metodos auxiliares

	private void esperar(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);

	}

	private void inicialize() {
		this.colector = new ColectorTemperatura(5000, 0);
	}

	private void clear() {
		this.colector.detenerColeccion();
		this.colector = null;
	}
	
	private ArrayList<Hora> getHorarios() {
		Hora amanecer = new Hora(6, 0, 0);
		Hora mañana = new Hora(9, 0, 0);
		Hora medioDia = new Hora(12, 0, 0);
		Hora tarde = new Hora(15, 0, 0);
		Hora atardecer = new Hora(18, 0, 0);
		Hora noche = new Hora(21, 0, 0);
		Hora mediaNoche = new Hora(24, 0, 0);
		Hora madrugada = new Hora(3, 0, 0);

		ArrayList<Hora> horarios = new ArrayList<Hora>();
		horarios.add(amanecer);
		horarios.add(mañana);
		horarios.add(medioDia);
		horarios.add(tarde);
		horarios.add(atardecer);
		horarios.add(noche);
		horarios.add(mediaNoche);
		horarios.add(madrugada);
		return horarios;

	}

	private boolean verificarTemperatura(ArrayList<Hora> horarios, Ambiente a) {
		boolean ret = true;
		for (Hora h : horarios) {
			a.setHoraActual(h);
			ret = ret && this.colector.medir().equals(a.getTemperatura());
		}
		return ret;
	}
	

}
