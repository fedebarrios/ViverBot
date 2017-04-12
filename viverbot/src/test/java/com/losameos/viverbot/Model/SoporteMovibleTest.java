package com.losameos.viverbot.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class SoporteMovibleTest {
	
	SoporteMovible soporteTest = null;
	private Plantas plantas = new Plantas();
	
	

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
	
	@Test
	public void podar(){
		inicialize();
		int cantidadPlantasAntes = plantas.cantidadPlantas();
		PlantaDTO plantaAPodar = plantas.obtenerPlantaEspecifica(1);
		boolean b = this.soporteTest.getPodador().podar(plantaAPodar);
		assertTrue(b);
		assertTrue(plantas.cantidadPlantas()==cantidadPlantasAntes-1);
		boolean b2= this.soporteTest.getPodador().podar(plantaAPodar);
		assertFalse(b2);
	}

	
	
	//metodos auxiliares
	
	private void inicialize(){
		this.soporteTest =  new SoporteMovible(Magnitudes.HUMEDAD);
	}
	
	private void  clear(){
		this.soporteTest = null;
	}

}
