package com.losameos.viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class SoporteMovibleTest {
	
	SoporteMovible soporteTest = null;
	
	

	@Test
	public void SoporteTest() {
		this.inicialize();
		UbicacionDTO u =  new UbicacionDTO(0,0);
		assertTrue(this.soporteTest.getColector() != null);
		assertTrue(this.soporteTest.getUbicacion().equals(u));
		this.clear();
	}
	
	@Test 
	public void moverTest(){
		this.inicialize();
		UbicacionDTO u = new UbicacionDTO(4,2);
		this.soporteTest.mover(u);
		
		assertTrue(this.soporteTest.getUbicacion().equals(u));
	}

	
	
	//metodos auxiliares
	
	private void inicialize(){
		this.soporteTest =  new SoporteMovible(Magnitudes.HUMEDAD);
	}
	
	private void  clear(){
		this.soporteTest = null;
	}

}
