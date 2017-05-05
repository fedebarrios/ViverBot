package viverbot.ControladorPlantas;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Especies.AltaEspecie_Controller;

public class AltaEspecieTest {
	private AltaEspecie_Controller controladorEspecies;
	
	@Test
	public void TestAltaEspecie(){
		controladorEspecies = new AltaEspecie_Controller();
		controladorEspecies.getAltaVista().dispose();
		assertTrue(controladorEspecies.esValido("Tomatina"));
		assertFalse(controladorEspecies.esValido("456"));	
		assertTrue(controladorEspecies.esValido("Tomate grande"));
		assertFalse(controladorEspecies.esValido("Tomate45")); 
		
		int cantidadEspeciesAntes = controladorEspecies.getInventario().obtenerEspecies().size();
		assertTrue(controladorEspecies.registrarEspecie("Cebolla", "Tomate", ""));
		assertFalse(controladorEspecies.registrarEspecie("Cebolla 45", "Tomate", ""));
		assertFalse(controladorEspecies.registrarEspecie("Cebolla", "Tomate 12", ""));
		int cantidadEspeciesDespues = controladorEspecies.getInventario().obtenerEspecies().size();
		assertTrue(cantidadEspeciesAntes+1 == cantidadEspeciesDespues);
	}
}
