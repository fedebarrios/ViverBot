package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.Estacion;

public class ControlTiempoTest {

	private ControlTiempo controlTiempoTest=null;

	@Test
	public void ValidaRiegoTempTest() {
		this.inicialize();
		assertTrue(this.controlTiempoTest != null);
		this.clear();

	}

	@Test
	public void AnalizarVeranoTest() {
		this.inicialize();
		if (controlTiempoTest.getEstacionAnio()==Estacion.VERANO)
			assertTrue(controlTiempoTest.esVerano());
		
	}
	
	@Test
	public void AnalizarInviernoTest() {
		this.inicialize();
		if (controlTiempoTest.getEstacionAnio()==Estacion.INVIERNO)
			assertTrue(controlTiempoTest.esInvierno());
	}


	
	@Test
	public void AnalizarDiaTest() {
		this.inicialize();
		if (controlTiempoTest.esDeDia())
			assertTrue(controlTiempoTest.esDeDia());
		
	}
	
	@Test
	public void AnalizarNocheTest() {
		this.inicialize();
		if (!controlTiempoTest.esDeDia())
			assertFalse(controlTiempoTest.esDeDia());
	}



	
	

	// metodos auxiliares

	private void inicialize() {
		controlTiempoTest=new ControlTiempo();

	}

	private void clear() {
		this.controlTiempoTest = null;
	}
}
