package com.losameos.viverbot.Controller.Medicion.Temperatura;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Humedad;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.InstrumentoMediator;
import com.losameos.viverbot.Model.Sensores.SensorHumedad;
import com.losameos.viverbot.Model.Sensores.SensorTemperatura;

public class ColectorTest {

	InstrumentoMediator colectroTest = null;

	@Test
	public void colectorMagnitudesTestTemperatura() {
		this.colectroTest = new InstrumentoMediator(Magnitudes.TEMPERATURA);
		assertTrue(this.colectroTest.getInstrumentoMedicion() instanceof SensorTemperatura);
		assertNull(this.colectroTest.getValorActual());
		this.clear();
	}

	@Test
	public void colectorMagnitudesTestHumedad() {
		this.colectroTest = new InstrumentoMediator(Magnitudes.HUMEDAD);
		assertTrue(this.colectroTest.getInstrumentoMedicion() instanceof SensorHumedad);
		assertNull(this.colectroTest.getValorActual());
		
		
		this.clear();
	}

	@Test
	public void testTomarMedicionTemperatura() {
		this.colectroTest = new InstrumentoMediator(Magnitudes.TEMPERATURA);
		Ambiente ambienteSimulado = new Ambiente();
		assertTrue(this.verificarTemperatura(this.getHorarios(), ambienteSimulado));
		assertTrue(this.colectroTest.getValorActual() instanceof Temperatura);

		clear();

	}
	
	@Test
	public void testTomarMedicionHumedad() {
		this.colectroTest = new InstrumentoMediator(Magnitudes.HUMEDAD);
		Ambiente ambienteSimulado = new Ambiente();
		assertTrue(this.verificarHumedad(this.getHorarios(), ambienteSimulado));
		assertTrue(this.colectroTest.getValorActual() instanceof Humedad);

		clear();

	}

	// metodos auxiliares
	private void clear() {
		this.colectroTest = null;

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
			ret = ret && this.colectroTest.tomarMedicion().equals(a.getTemperatura());
		}
		return ret;
	}
	
	private boolean verificarHumedad(ArrayList<Hora> horarios, Ambiente a) {
		boolean ret = true;
		for (Hora h : horarios) {
			a.setHoraActual(h);
			ret = ret && colectroTest.tomarMedicion().equals(a.getHumedad());
		}
		return ret;
	}

}
