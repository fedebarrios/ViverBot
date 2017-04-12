package com.losameos.viverobot.Model.Plantas;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.Test;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Plantas;

public class PlantasTest {
	
	private static Plantas plantas = null;
	
	@Test
	public void testAltaPlantas() {
		inicializar();
		Integer cantidadPlantas = plantas.obtenerPlantas(1).size();
		System.out.println("Cantidad de plantas: "+cantidadPlantas);
		assertTrue(cantidadPlantas==6);
		
		System.out.println("Se carga una nueva planta");
		plantas.agregarPlanta(1, "34,543", new Fecha(10,10,1994));
		cantidadPlantas = plantas.obtenerPlantas(1).size();

		assertTrue(cantidadPlantas==7);
		System.out.println("nueva cantidad: "+cantidadPlantas);
		clear();
	}
	
	private void inicializar()
	{
	}
	private void clear()
	{
		plantas = null;
	}

}
