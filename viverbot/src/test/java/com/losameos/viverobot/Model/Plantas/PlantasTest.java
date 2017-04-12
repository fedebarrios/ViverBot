package com.losameos.viverobot.Model.Plantas;

import static org.junit.Assert.*;
import org.junit.Test;

import com.losameos.viverbot.DAO.PlantaDAO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Plantas;

public class PlantasTest {

	private static Plantas plantas;
	private static PlantaDAO plantaDAO;

	@Test
	public void testAgregarPlantas() {
		inicializar();
		// La cantidad de plantas iniciales son:
		Integer cantidadPlantas = plantas.obtenerPlantas().size();
		assertTrue(cantidadPlantas == 6);

		// Agregaremos una nueva planta
		plantas.agregarPlanta(1, "34,543", new Fecha(10, 10, 1994));
		cantidadPlantas = plantas.obtenerPlantas().size();

		// Ahora la cantidad de plantas se incremento
		assertTrue(cantidadPlantas == 7);
	}
	@Test
	public void testEliminarPlanta() {
		inicializar();
		// La cantidad de plantas iniciales son:
		Integer cantidadPlantas = plantas.obtenerPlantas().size();
		assertTrue(cantidadPlantas == 6);

		// Agregaremos una nueva planta
		plantas.agregarPlanta(1, "34,543", new Fecha(10, 10, 1994));
		PlantaDTO plantaPorCrear = new PlantaDTO(1, plantaDAO.obtenerUltimoCodigo(),new UbicacionDTO(34,543), 
																					new Fecha(10, 10, 2017));
		cantidadPlantas = plantas.obtenerPlantas().size();
		System.out.println(plantaPorCrear.getUbicacion().getFila() + " " +plantaPorCrear.getUbicacion().getColumna());
		// Ahora la cantidad de plantas se incremento
		assertTrue(cantidadPlantas == 7);
		int codPlanta = plantaDAO.obtenerUltimoCodigo();
		PlantaDTO plantaEnPersistencia = plantas.obtenerPlanta(codPlanta);
		
		System.out.println(plantaEnPersistencia.getUbicacion().getFila() + " " +plantaEnPersistencia.getUbicacion().getColumna());
		//assertTrue(plantaEnPersistencia.equals(plantaPorCrear));
		
		plantas.eliminarPlanta(plantaPorCrear.getCodigoPlanta());
		
		assertFalse(plantas.obtenerPlantas().contains(plantaPorCrear));
	}

	private void inicializar() {
		plantas = new Plantas();
		plantaDAO = new PlantaDAO();
	}
}
