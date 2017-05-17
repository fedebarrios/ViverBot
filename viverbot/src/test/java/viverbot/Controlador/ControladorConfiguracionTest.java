package viverbot.Controlador;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.File;

import org.junit.Test;

import viverbot.MockFileChooser;
import viverbot.MockOptionPane;
import viverbot.Vista.Auxiliares.FileChooser;

public class ControladorConfiguracionTest {
	ControladorConfiguracionDirectorio conf;

	@Test
	public void chequearSiSelecciono(){
		inicialize();
		
		conf.getVista().setRdDirectorio1(false);
		conf.getVista().setRdDirectorio1(false);
		conf.getVista().setRdDirectorio1(false);
		conf.setOptionPane(new MockOptionPane());
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnCargarDirectorio(), 0, ""));
		assertFalse(conf.eligioDirectorio());
		
		conf.getVista().setRdDirectorio2(true);
		assertTrue(conf.eligioDirectorio());
		assertEquals(2,conf.getDirectorioSeleccionado());
		
		conf.getVista().setRdDirectorio1(true);
		assertTrue(conf.eligioDirectorio());
		assertEquals(1,conf.getDirectorioSeleccionado());
		
		conf.getVista().setRdDirectorio3(true);
		assertTrue(conf.eligioDirectorio());
		assertEquals(3,conf.getDirectorioSeleccionado());
	}
	
	@Test
	public void llenarCampos(){
		inicialize();
		conf.getVista().setRdDirectorio3(true);
		MockFileChooser fileChooser = new MockFileChooser("src\\main\\java");
		conf.setFileChooser(fileChooser);
		conf.setOptionPane(new MockOptionPane());
		conf.actionPerformed(new ActionEvent(conf.getVista().getBtnCargarDirectorio(), 1, ""));
		assertEquals("src\\main\\java",conf.getVista().getDirectorio3().getText());
	}
	
	public void inicialize(){
		conf = new ControladorConfiguracionDirectorio();
	}
}
