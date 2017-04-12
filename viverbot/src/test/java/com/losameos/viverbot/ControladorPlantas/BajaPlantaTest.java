package com.losameos.viverbot.ControladorPlantas;
import static org.junit.Assert.*;

import org.junit.Test;
import com.losameos.viverbot.Controller.AltaEspecie_Controller;
import com.losameos.viverbot.DAO.PlantaDAO;

public class BajaPlantaTest {
	private static Controlador_BajaPlanta controladorPlantas = null;
	private static AltaEspecie_Controller controladorEspecies = null;
	
	private void inicialize() {
		controladorEspecies = new AltaEspecie_Controller();
		controladorEspecies.inventario.agregarEspecie("Tomate", "Tomatus", "rosa.jpg");
		controladorPlantas = new Controlador_BajaPlanta(); 
	}
	
	@Test
	public void testLlenarComboPlantas() {
		inicialize();
		int cantItemsIniciales = PlantaDAO.getInstance().obtenerPlantas().size();
		controladorPlantas.inicializar();
		int cantItemsFinales = controladorPlantas.getVistaBajaPlanta().getCmbPlantas().getModel().getSize();
		assertEquals(cantItemsIniciales, cantItemsFinales);  
	}
	
	@Test
	public void testBorrarItemPlanta() {
		inicialize();
		int cantItemsIniciales = PlantaDAO.getInstance().obtenerPlantas().size();
		controladorPlantas.inicializar();
		int cantItemsFinales = controladorPlantas.getVistaBajaPlanta().getCmbPlantas().getModel().getSize();
		assertEquals(cantItemsIniciales, cantItemsFinales);  
		
		controladorPlantas.borrarItemPlanta(1);
		assertTrue(cantItemsFinales==cantItemsIniciales);
	}
	
	@Test
	public void testObtenerIndiceSeleccionado(){
		inicialize();
		controladorPlantas.inicializar();
		int indiceSeleccionadoEnVista = controladorPlantas.getVistaBajaPlanta().getCmbPlantas().getSelectedIndex();
		int indiceSeleccionado = controladorPlantas.obtenerIndiceSeleccionado();
		assertEquals(indiceSeleccionado, indiceSeleccionadoEnVista);
	}
	
}
