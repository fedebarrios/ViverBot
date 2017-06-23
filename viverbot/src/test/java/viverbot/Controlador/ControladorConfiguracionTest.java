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
	public void llenarCampos(){
		inicialize();
		
		
	}
	
	public void inicialize(){
		conf = new ControladorConfiguracionDirectorio();
	}
}
