package com.losameos.viverbot.Model.Sensores;

import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

import junit.framework.TestCase;

public class SensorTemperaturaTest extends TestCase {
	private static SensorTemperatura sensorTest = null;

	// este test verifica que el return sea de tipo temperatura
	@Test
	public void testGetMedicionVerificarClase() {
		inicialize();
		assertTrue(sensorTest.getMedicion() instanceof Temperatura);
		clear();
	}

	// este test verifica que la temperatura sea correcta durante el cada
	// horario definido
	@Test
	public void testGetMedicion() {
		inicialize();

		Ambiente ambienteSimulado = new Ambiente();

		assertTrue(this.verificarTemperatura(this.getHorarios(), ambienteSimulado));
		clear();
	}

	/// metodos auxiliares

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

	private void inicialize() {
		sensorTest = new SensorTemperatura();
	}

	private boolean verificarTemperatura(ArrayList<Hora> horarios, Ambiente a) {
		boolean ret = true;
		for (Hora h : horarios) {
			a.setHoraActual(h);
			ret = ret && sensorTest.getMedicion().equals(a.getTemperatura());
		}
		return ret;
	}

	private void clear() {

		sensorTest = null;

	}

}
