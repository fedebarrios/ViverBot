package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class ValidaRiegoTemperaturaTest {

	//private AnalizadorTemperatura analizadroTest = null;
	private ValidaRiegoTemperatura validaRiegoTempTest=null;
	private Temperatura temperaturaOptima = new Temperatura(15.0);
	private Temperatura temperaturaBaja = new Temperatura(5.0);
	private Temperatura temperaturaAlta = new Temperatura(25.0);

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
//		assertTrue(this.analizadroTest.getRango() != null);
		assertTrue(this.validaRiegoTempTest.tempActual != null);
		this.clear();

	}

	@Test
	public void AnalizarOptimoTest() {
		this.inicialize();
		Temperatura tO= new Temperatura(validaRiegoTempTest.tempActual.getValorTemperatura()); 
		assertTrue(!tO.equals(temperaturaOptima));

	}
	
	@Test
	public void AnalizarBajoTest() {
		this.inicialize();
		Temperatura tO= new Temperatura(validaRiegoTempTest.tempActual.getValorTemperatura()); 		
		assertTrue(!tO.equals(temperaturaBaja));

	}
	
	@Test
	public void AnalizarAltoTest() {
		this.inicialize();
		Temperatura tO= new Temperatura(validaRiegoTempTest.tempActual.getValorTemperatura()); 		
		assertTrue(tO.equals(temperaturaAlta));
	}
	
	

	// metodos auxiliares

	private void inicialize() {
		validaRiegoTempTest=new ValidaRiegoTemperatura();

	}

	private void clear() {
		this.validaRiegoTempTest = null;
	}
}
