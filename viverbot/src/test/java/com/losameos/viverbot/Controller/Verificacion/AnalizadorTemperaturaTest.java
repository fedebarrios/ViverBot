package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AnalizadorTemperaturaTest {

	private AnalizadorTemperatura analizadroTest = null;
	private RangoNumerico rango = new RangoNumerico(10.0, 20.0);
	private Temperatura temperaturaOptima = new Temperatura(15.0);
	private Temperatura temperaturaBaja = new Temperatura(5.0);
	private Temperatura temperaturaAlta = new Temperatura(25.0);

	@Test
	public void AnalizadorTest() {
		this.inicialize();
		assertNotNull(this.analizadroTest.getRango());
		assertNull(this.analizadroTest.getEstado());
		this.clear();

	}

	@Test
	public void AnalizarOptimoTest() {
		this.inicialize();
		this.analizadroTest.setRango(this.rango);
		this.analizadroTest.analizar(temperaturaOptima);
		assertTrue(this.analizadroTest.getEstado().getOptima() == true);
		assertTrue(this.analizadroTest.getEstado().getTemperatura().equals(temperaturaOptima));
		assertNotNull(this.analizadroTest.getEstado());

	}
	
	@Test
	public void AnalizarBajoTest() {
		this.inicialize();
		this.analizadroTest.setRango(this.rango);
		this.analizadroTest.analizar(this.temperaturaBaja);
		assertTrue(this.analizadroTest.getEstado().getOptima() == false);
		assertTrue(this.analizadroTest.getEstado().getTemperatura().equals(temperaturaBaja));
		assertNotNull(this.analizadroTest.getEstado());


	}
	
	@Test
	public void AnalizarAltoTest() {
		this.inicialize();
		this.analizadroTest.setRango(this.rango);
		this.analizadroTest.analizar(this.temperaturaAlta);
		assertTrue(this.analizadroTest.getEstado().getOptima() == false);
		assertTrue(this.analizadroTest.getEstado().getTemperatura().equals(this.temperaturaAlta));
		assertNotNull(this.analizadroTest.getEstado());


	}
	
	@Test
	public void VerificarRangoOptimoTest() {
		this.inicialize();
		this.analizadroTest.setRango(this.rango);
		assertTrue(this.analizadroTest.verificarTemperatura(temperaturaOptima) == 0);
		

	}
	
	@Test
	public void VerificarRangoBajaTest() {
		this.inicialize();
		this.analizadroTest.setRango(this.rango);
		assertTrue(this.analizadroTest.verificarTemperatura(this.temperaturaBaja) == -1);
		

	}@Test
	public void VerificarRangoAltaTest() {
		this.inicialize();
		this.analizadroTest.setRango(this.rango);
		assertTrue(this.analizadroTest.verificarTemperatura(this.temperaturaAlta) == 1);
		

	}
	

	// metodos auxiliares

	private void inicialize() {
		this.analizadroTest = new AnalizadorTemperatura();

	}

	private void clear() {
		this.analizadroTest = null;
	}
}
