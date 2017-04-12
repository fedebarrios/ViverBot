package com.losameos.viverbot.Controller.Verificacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class TransmisorAlturaTest {
	private TransmisorAltura transmisorTest;
	private Thread hilo;
	private static Plantas p =  new Plantas();
	
	@Test
	public void TransmisorTest(){
		this.inicialize();
		ArrayList<PlantaDTO> plantasVacias = new ArrayList<PlantaDTO> ();
		transmisorTest.setListadoPlantas(plantasVacias);
		assertNotNull(this.transmisorTest.getColector());
		assertEquals(TransmisorAltura.getTipoMagnitud(), Magnitudes.ALTURA);
		this.clear();
	}
	
	private void inicialize() {
		this.transmisorTest = new TransmisorAltura(SoporteFactory.crearSoporte(Magnitudes.ALTURA));
		this.hilo = new Thread(this.transmisorTest);
	}
	
	private void clear() {
		this.transmisorTest = null;
		this.hilo = null;
	}
}
