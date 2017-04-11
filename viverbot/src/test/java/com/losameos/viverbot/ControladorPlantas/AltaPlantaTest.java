package com.losameos.viverbot.ControladorPlantas;

import java.sql.Date;
import org.junit.Test;
import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;

public class AltaPlantaTest {
	
	private static PlantaDTO planta = null;
	private static Controlador_AltaPlanta controladorPlantas = null;
	private static EspecieDTO especie = null;
	private static AltaEspecie_Controller controladorEspecies = null;
	
	private void inicialize() {
		controladorEspecies = new AltaEspecie_Controller();
		controladorEspecies.inventario.agregarEspecie("Tomate", "Tomatus", "tomate.jpg");
		planta = new PlantaDTO(1, 1, new UbicacionDTO(0,0), new Date(10,10,2017));
		controladorPlantas = new Controlador_AltaPlanta();
	}
	
	@Test
	public void test() {
		
	}

}  
