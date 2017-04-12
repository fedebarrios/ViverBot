package com.losameos.viverbot.Controller;

import org.junit.Test;

import com.losameos.viverbot.DAO.PlantaDAO;
import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.Model.Plantas;

import junit.framework.TestCase;


public class VerDetallesEspecieTest extends TestCase {
	private static EspecieDTO especie = null;
	private static VerDetallesEspecie_Controller controlador = null;
	private static Plantas planta = null;
	
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
		assertFalse(cantidad==6);
		clear();
	}
	
	@Test
	//Falla al buscar imagen de especie
	public void testSolicitarSinPlantas()
	{
		//
	}
	
	private void inicialize() {
		planta = new Plantas();
		especie = new EspecieDTO(1,"especie1","prueba","rosa.jpg");
		controlador = new VerDetallesEspecie_Controller(especie);
	}

	private void clear() {
		controlador = null;
		especie = null;
	}

}
