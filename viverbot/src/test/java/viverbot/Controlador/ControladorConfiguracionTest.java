package viverbot.Controlador;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.File;

import org.junit.Test;

import viverbot.MockFileChooser;
import viverbot.MockOptionPane;
import viverbot.Archivos.GatewayConfiguracion;
import viverbot.Vista.Auxiliares.FileChooser;

public class ControladorConfiguracionTest {
	ControladorConfiguracionDirectorio conf;

	@Test
	public void noEligioDirectorio(){

		conf = new ControladorConfiguracionDirectorio();
		GatewayConfiguracion.limpiar();
		GatewayConfiguracion.agregarDirectorio("c/usuario");
		assertEquals(1 , GatewayConfiguracion.getDirectorios().size());	

		GatewayConfiguracion.agregarDirectorio("c/desktop");
		assertEquals(2 , GatewayConfiguracion.getDirectorios().size());
		
		conf.llenarCampos();
		conf.getVista().getComboBox().setSelectedIndex(0);
		assertFalse(conf.eligioDirectorio());

		conf.getVista().getComboBox().setSelectedIndex(2);
		assertTrue(conf.eligioDirectorio());
	
	}
	

	@Test
	public void guardoDirectorio(){

		conf = new ControladorConfiguracionDirectorio();
		GatewayConfiguracion.limpiar();
		GatewayConfiguracion.agregarDirectorio("c/usuario");
		assertEquals(1 , GatewayConfiguracion.getDirectorios().size());	

		GatewayConfiguracion.agregarDirectorio("c/desktop");
		assertEquals(2 , GatewayConfiguracion.getDirectorios().size());
		
		MockFileChooser fileChooser = new MockFileChooser();
		fileChooser.setFile(new File("C/Documents"));
		conf.setFileChooser(fileChooser);
		conf.llenarCampos();
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnCargarDirectorio(), 1, ""));
		
		assertEquals(3, GatewayConfiguracion.getDirectorios().size());
	
	}
}
