package com.losameos.viverbot.Controller;

import org.junit.Test;
import com.losameos.viverbot.DTO.EspecieDTO;
import junit.framework.TestCase;


public class VerDetallesEspecieTest extends TestCase {
	private static EspecieDTO especie = null;
	private static VerDetallesEspecie_Controller controlador = null;
	
	@Test
	public void testInstancia() {
		inicialize();
		assertNotNull(controlador);
		this.clear();

	}
	
	@Test
	public void testCantidadPlantas()
	{
		inicialize();
		especie = new EspecieDTO(2,"especie1","prueba","rosa.jpg");
		Integer cantidad = controlador.getPlantas().obtenerPlantas(especie.getCodEspecie()).size();
		assertTrue(cantidad==6);
		clear();
	}
	
	@Test
	//Falla al buscar imagen de especie
	public void testSolicitarSinPlantas()
	{
		//
	}
	
	private void inicialize() {
		especie = new EspecieDTO(1,"especie1","prueba","rosa.jpg");
		controlador = new VerDetallesEspecie_Controller(especie);
	}

	private void clear() {
		controlador = null;
		especie = null;
	}

}
