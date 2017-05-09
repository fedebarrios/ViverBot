package viverbot.ControladorPlantas;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.junit.Test;

import viverbot.Controlador.Especies.AltaEspecie_Controller;

public class AltaEspecieTest {
	private AltaEspecie_Controller controladorEspecies;
	
	@Test
	public void TestSeAgregoEspecie(){
		inicializar();
		int cantidadEspeciesAntes = controladorEspecies.getInventario().obtenerEspecies().size();
		assertTrue(controladorEspecies.registrarEspecie("Rosa","Neptilus","recursos/arbol.jpg"));
		int cantidadEspeciesDespues = controladorEspecies.getInventario().obtenerEspecies().size();
		assertEquals(cantidadEspeciesAntes+1 , cantidadEspeciesDespues);
	} 
	
	@Test
	public void TestNoSePuedoAgregarEspecie(){
		inicializar();
		int cantidadEspeciesAntes = controladorEspecies.getInventario().obtenerEspecies().size();
		//Se quito la url de la imagen
		assertFalse(controladorEspecies.registrarEspecie("Rosa","Neptilus",""));
		int cantidadEspeciesDespues = controladorEspecies.getInventario().obtenerEspecies().size();
		assertEquals(cantidadEspeciesAntes , cantidadEspeciesDespues);
	}
	
	@Test
	public void TestLimpiar(){
		inicializar();
		controladorEspecies.limpiar();
		assertTrue(controladorEspecies.nombreEspecieVacio());
		assertTrue(controladorEspecies.nombreCientificoVacio());
		assertTrue(controladorEspecies.nombreImagenVacio());
	}
	
	@Test
	public void TestNoVacio(){
		inicializar();
		assertFalse(controladorEspecies.nombreEspecieVacio());
		assertFalse(controladorEspecies.nombreCientificoVacio());
		assertFalse(controladorEspecies.nombreImagenVacio());
	}
	 
	@Test
	public void TestActionPerformedGuardar(){
		inicializar();
		int cantidadEspeciesAntes = controladorEspecies.getInventario().obtenerEspecies().size();
		controladorEspecies.actionPerformed(new ActionEvent(controladorEspecies.getAltaVista().getGuardar_btn(), 1, ""));
		int cantidadEspeciesDespues = controladorEspecies.getInventario().obtenerEspecies().size();
		assertEquals(cantidadEspeciesAntes +1, cantidadEspeciesDespues);
	}
	
	@Test
	public void TestActionPerformedCancelar(){
		inicializar();
		controladorEspecies.getAltaVista().setVisible(true);
		controladorEspecies.actionPerformed(new ActionEvent(controladorEspecies.getAltaVista().getCancelar_btn(), 1, ""));
		assertFalse(controladorEspecies.getAltaVista().isVisible());
	} 
	
//	@Test
//	public void TestActionPerformedGuardarNombreEspecieVacio(){
//		inicializar();
//		int cantidadEspeciesAntes = controladorEspecies.getInventario().obtenerEspecies().size();
//		controladorEspecies.getAltaVista().getNombreEspecie_tf().setText("");;
//		controladorEspecies.actionPerformed(new ActionEvent(controladorEspecies.getAltaVista().getGuardar_btn(), 1, ""));
//		int cantidadEspeciesDespues = controladorEspecies.getInventario().obtenerEspecies().size();
//		assertEquals(cantidadEspeciesAntes, cantidadEspeciesDespues);
//	}
	
	public void inicializar(){
		controladorEspecies = new AltaEspecie_Controller();
		controladorEspecies.getAltaVista().dispose();
		controladorEspecies.getAltaVista().getNombreEspecie_tf().setText("Cebolla de verdeo");
		controladorEspecies.getAltaVista().getNombreCientifico_tf().setText("Cebolla");
		controladorEspecies.getAltaVista().getImagen_tf().setText("jeje");
	}
}
