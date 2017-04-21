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
<<<<<<< HEAD
=======
//		assertTrue(this.analizadroTest.getRango() != null);
>>>>>>> origin/master
		assertTrue(this.validaRiegoTempTest.tempActual != null);
		this.clear();

	}

	@Test
	public void AnalizarOptimoTest() {
		this.inicialize();
<<<<<<< HEAD
		Temperatura tO= validaRiegoTempTest.tempActual.getValorTemperatura(); 
=======
		Temperatura tO= new Temperatura(validaRiegoTempTest.tempActual.getValorTemperatura()); 
>>>>>>> origin/master
		assertTrue(!tO.equals(temperaturaOptima));

	}
	
	@Test
	public void AnalizarBajoTest() {
		this.inicialize();
<<<<<<< HEAD
		Temperatura tO= validaRiegoTempTest.tempActual.getValorTemperatura(); 		
=======
		Temperatura tO= new Temperatura(validaRiegoTempTest.tempActual.getValorTemperatura()); 		
>>>>>>> origin/master
		assertTrue(!tO.equals(temperaturaBaja));

	}
	
	@Test
	public void AnalizarAltoTest() {
		this.inicialize();
<<<<<<< HEAD
		Temperatura tO= validaRiegoTempTest.tempActual.getValorTemperatura(); 		
=======
		Temperatura tO= new Temperatura(validaRiegoTempTest.tempActual.getValorTemperatura()); 		
>>>>>>> origin/master
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
