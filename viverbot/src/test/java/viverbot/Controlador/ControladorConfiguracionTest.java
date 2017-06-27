package viverbot.Controlador;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.File;

import org.junit.Test;

import viverbot.MockFileChooser;
import viverbot.MockOptionPane;
import viverbot.Archivos.GatewayConfiguracion;

public class ControladorConfiguracionTest {
	
	@Test
	public void noEligioDirectorioOptionPane(){
		ControladorConfiguracionDirectorio conf = new ControladorConfiguracionDirectorio();
		MockFileChooser fileChooser = new MockFileChooser();
		fileChooser.setFile(null);
		conf.setFileChooser(fileChooser);
		conf.setOptionPane(new MockOptionPane());
		int cantidadDirectoriosAntes = GatewayConfiguracion.getDirectorios().size();
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnCargarDirectorio(), 1, ""));
		assertEquals(cantidadDirectoriosAntes, GatewayConfiguracion.getDirectorios().size());
	}
	
	@Test
	public void noEligioDirectorioComboBox(){

		ControladorConfiguracionDirectorio conf = new ControladorConfiguracionDirectorio();
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
	public void borrarDirectorio(){
		ControladorConfiguracionDirectorio conf = new ControladorConfiguracionDirectorio();
		GatewayConfiguracion.limpiar();
		GatewayConfiguracion.agregarDirectorio("c/usuario");
		GatewayConfiguracion.agregarDirectorio("c/desktop");
		conf.llenarCampos();
		conf.getVista().getComboBox().setSelectedIndex(2);
		
		int cantidadDirectoriosAntes = GatewayConfiguracion.getDirectorios().size();
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnBorrarDirectorio(), 1, ""));
		assertEquals(cantidadDirectoriosAntes-1, GatewayConfiguracion.getDirectorios().size());
		
	}
	
	@Test
	public void noSePudoBorrarDirectorio(){
		ControladorConfiguracionDirectorio conf = new ControladorConfiguracionDirectorio();
		GatewayConfiguracion.limpiar();
		GatewayConfiguracion.agregarDirectorio("c/usuario");
		GatewayConfiguracion.agregarDirectorio("c/desktop");
		conf.llenarCampos();
		conf.setOptionPane(new MockOptionPane());
		conf.getVista().getComboBox().setSelectedIndex(0);
		
		int cantidadDirectoriosAntes = GatewayConfiguracion.getDirectorios().size();
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnBorrarDirectorio(), 1, ""));
		assertEquals(cantidadDirectoriosAntes, GatewayConfiguracion.getDirectorios().size());
		
	}
	
	@Test
	public void guardoDirectorio(){

		ControladorConfiguracionDirectorio conf = new ControladorConfiguracionDirectorio();
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
