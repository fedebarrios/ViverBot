package com.losameos.viverobot.Model.Plantas;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.dto.PlantaDTO;

public class PlantasTest {
	
	private static Plantas plantas = null;
	
	@Test
	public void testAltaPlantas() {
		inicializar();
		Integer cantidadPlantas = plantas.obtenerPlantas("especie3").size();
		System.out.println("Cantidad de plantas: "+cantidadPlantas);
		assertTrue(cantidadPlantas==6);
		
		System.out.println("Se carga una nueva planta");
		PlantaDTO nuevaPlanta = new PlantaDTO(32,new Ubicacion(34,543));
		plantas.agregarPlanta("especie3", nuevaPlanta);
		cantidadPlantas = plantas.obtenerPlantas("especie3").size();

		assertTrue(cantidadPlantas==7);
		System.out.println("nueva cantidad: "+cantidadPlantas);
		clear();
	}
	
	private void inicializar()
	{
		plantas = new Plantas();
	}
	private void clear()
	{
		plantas = null;
	}

}
