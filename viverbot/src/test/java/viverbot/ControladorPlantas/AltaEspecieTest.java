package viverbot.ControladorPlantas;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Especies.AltaEspecie_Controller;

public class AltaEspecieTest {
	private AltaEspecie_Controller controladorEspecies;
	
	@Test
	public void TestSeAgregoEspecie(){
		inicializar();
		int cantidadEspeciesAntes = controladorEspecies.getInventario().obtenerEspecies().size();
		assertTrue(controladorEspecies.registrarEspecie());
		int cantidadEspeciesDespues = controladorEspecies.getInventario().obtenerEspecies().size();
		assertEquals(cantidadEspeciesAntes+1 , cantidadEspeciesDespues);
	}
	
	@Test
	public void TestNoSePuedoAgregarEspecie(){
		inicializar();
		controladorEspecies.getAltaVista().getImagen_tf().setText("");
		int cantidadEspeciesAntes = controladorEspecies.getInventario().obtenerEspecies().size();
		assertFalse(controladorEspecies.registrarEspecie());
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
	
	public void inicializar(){
		controladorEspecies = new AltaEspecie_Controller();
		controladorEspecies.getAltaVista().getNombreEspecie_tf().setText("Cebolla de verdeo");
		controladorEspecies.getAltaVista().getNombreCientifico_tf().setText("Cebolla");
		controladorEspecies.getAltaVista().getImagen_tf().setText("jeje");
	}
}
