package viverbot.ControladorPlantas;
import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

import viverbot.MockOptionPane;
import viverbot.Controlador.Especies.AltaEspecie_Controller;
import viverbot.Controlador.Plantas.Controlador_BajaPlanta;
import viverbot.DAO.PlantaDAO;

public class BajaPlantaTest {
	private static Controlador_BajaPlanta controladorPlantas = null;
	private static AltaEspecie_Controller controladorEspecies = null;
	
	private void inicialize() {
		controladorEspecies = new AltaEspecie_Controller();
		controladorEspecies.getInventario().agregarEspecie("Tomate", "Tomatus", "rosa.jpg");
		controladorPlantas = new Controlador_BajaPlanta(); 
	}
	
	@Test
	public void testLlenarComboPlantas() {
		inicialize();
		int cantItemsIniciales = PlantaDAO.getInstance().obtenerPlantas().size();
		controladorPlantas.inicializar();
		int cantItemsFinales = controladorPlantas.getVistaBajaPlanta().getCmbPlantas().getModel().getSize();
		assertEquals(cantItemsIniciales, cantItemsFinales);  
		controladorPlantas.getVistaBajaPlanta().cerrarVentana();
	}
	
	@Test
	public void testBorrarItemPlanta() {
		inicialize();
		int cantItemsIniciales = PlantaDAO.getInstance().obtenerPlantas().size();
		controladorPlantas.inicializar();
		int cantItemsFinales = controladorPlantas.getVistaBajaPlanta().getCmbPlantas().getModel().getSize();
		assertEquals(cantItemsIniciales, cantItemsFinales); 
		 
		controladorPlantas.borrarItemPlanta(0);
		assertTrue(cantItemsFinales==cantItemsIniciales);
		controladorPlantas.getVistaBajaPlanta().cerrarVentana();
	}
	
	@Test
	public void testObtenerIndiceSeleccionado(){
		inicialize();
		controladorPlantas.inicializar();
		int indiceSeleccionadoEnVista = controladorPlantas.getVistaBajaPlanta().getCmbPlantas().getSelectedIndex();
		int indiceSeleccionado = controladorPlantas.obtenerIndiceSeleccionado();
		assertEquals(indiceSeleccionado, indiceSeleccionadoEnVista);
		controladorPlantas.getVistaBajaPlanta().cerrarVentana();
	}
	
	@Test
	public void testInicializarControladorConVentanaVisible(){
		inicialize();
		controladorPlantas.inicializar();
		controladorPlantas.inicializar();
		assertTrue(controladorPlantas.getVistaBajaPlanta().isVisible());
	}
	
	@Test
	public void testActionPerformedCancelar(){
		inicialize();
		controladorPlantas.inicializar();
		controladorPlantas.actionPerformed(new ActionEvent(controladorPlantas.getVistaBajaPlanta().getBtnCancelar(), 1, ""));
		assertFalse(controladorPlantas.getVistaBajaPlanta().isVisible());
	}
	
	@Test
	public void testActionPerformedBorrar(){
		inicialize();
		int cantPlantasIniciales = PlantaDAO.plantaDAO.cantidadPlantas();
		controladorPlantas.inicializar();
		controladorPlantas.actionPerformed(new ActionEvent(controladorPlantas.getVistaBajaPlanta().getBtnBorrar(), 1, ""));
		int cantPlantasFinales = PlantaDAO.plantaDAO.cantidadPlantas();
		assertTrue(cantPlantasIniciales>cantPlantasFinales);
	}
	
	@Test
	public void testActionPerformedBorrarSinSeleccionarItem(){
		inicialize();
		int cantPlantasIniciales = PlantaDAO.plantaDAO.cantidadPlantas();
		controladorPlantas.inicializar();
		controladorPlantas.getVistaBajaPlanta().getCmbPlantas().removeAllItems();
		controladorPlantas.setOptionPane(new MockOptionPane());
		controladorPlantas.actionPerformed(new ActionEvent(controladorPlantas.getVistaBajaPlanta().getBtnBorrar(), 1, ""));
		int cantPlantasFinales = PlantaDAO.plantaDAO.cantidadPlantas();
		assertEquals(cantPlantasIniciales,cantPlantasFinales);
	}
	
}
