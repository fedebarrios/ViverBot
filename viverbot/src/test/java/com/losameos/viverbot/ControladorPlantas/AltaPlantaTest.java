package com.losameos.viverbot.ControladorPlantas;

import static org.junit.Assert.*;
import java.sql.Date;
import org.junit.Test;
import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.DAO.PlantaDAO;

public class AltaPlantaTest {
	
	private static Controlador_AltaPlanta controladorPlantas = null;
	private static AltaEspecie_Controller controladorEspecies = null;
	
	private void inicialize() {
		controladorEspecies = new AltaEspecie_Controller();
		controladorEspecies.inventario.agregarEspecie("Tomate", "Tomatus", "rosa.jpg");
		controladorPlantas = new Controlador_AltaPlanta();
		System.out.println(PlantaDAO.getInstance().obtenerPlantas().size());
	}
	
	@Test
	public void testRegistrarPlanta() {
		inicialize();
		int cantPlantasInicio = PlantaDAO.getInstance().obtenerPlantas().size();
		controladorPlantas.inicializar();
		controladorPlantas.getVista().getTextUbicacion().setText("0,0");
		controladorPlantas.getVista().getCmbEspecies().setSelectedIndex(1);
		controladorPlantas.getVista().setDateFiltro(new Date(10/10/2017));
		controladorPlantas.registrarPlanta();
		int cantPlantasFinal = PlantaDAO.getInstance().obtenerPlantas().size();
		assertTrue(cantPlantasInicio==cantPlantasFinal-1);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCamposValidos(){
		inicialize();
		controladorPlantas.inicializar();
		controladorPlantas.getVista().getTextUbicacion().setText("0,0");
		controladorPlantas.getVista().getCmbEspecies().setSelectedIndex(1);
		controladorPlantas.getVista().setDateFiltro(new Date(2017-1900,4-1,10));
		assertTrue(controladorPlantas.camposValidos());
	}

}  