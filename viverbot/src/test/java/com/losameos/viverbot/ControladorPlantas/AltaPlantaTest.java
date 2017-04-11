package com.losameos.viverbot.ControladorPlantas;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.Controller.VerDetallesEspecie_Controller;
import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;

public class AltaPlantaTest {
	
	private static PlantaDTO planta = null;
	private static Controlador_AltaPlanta controladorPlantas = null;
	private static EspecieDTO especie = null;
	private static AltaEspecie_Controller controladorEspecies = null;
	
	private void inicialize() {
		especie = new EspecieDTO(1, "Tomate", "Tomatus", "tomate.jpg");
		controladorEspecies = new AltaEspecie_Controller();
		planta = new PlantaDTO(1, 1, new UbicacionDTO(0,0), new Date(10,10,2017));
		controladorPlantas = new Controlador_AltaPlanta();
	}
	
	@Test
	public void test() {
		
	}

}
