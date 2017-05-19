package viverbot.Controlador;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.File;

import org.junit.Test;

import viverbot.MockOptionPane;
import viverbot.Archivos.CargadorArchivos;
import viverbot.Archivos.GatewayConfiguracion;

public class ControladorAnalizadorAlturaTest {
	ControladorAnalizadorAltura controlador;
	
	@SuppressWarnings("deprecation")
	@Test
	public void verificarPlantasCargadas() throws Exception{
		controlador = new ControladorAnalizadorAltura();
		inicialize(controlador);
		controlador.setOptionPane(new MockOptionPane());
		controlador.getVista().getBtnAnalizarPlanta().doClick();
		assertEquals(controlador.getVista().getComboPlantas().getModel().getSize(), 6);
	}
	
	@Test
	public void analizarPlanta() throws Exception{
		controlador = new ControladorAnalizadorAltura();
		inicialize(controlador);
		controlador.setOptionPane(new MockOptionPane());
		controlador.getVista().getBtnAnalizarPlanta().doClick();
		assertEquals(controlador.getMensaje(), "El estado es: Normal");
	}
	
	public void inicialize(ControladorAnalizadorAltura controlador) throws Exception{
		String[] directorios = {"src/test/java/viverbot/Archivos/DirectorioTest1",
				"src/test/java/viverbot/Archivos/DirectorioTest2",
				"src/test/java/viverbot/Archivos/EstadosAlturaFiles"};
		int i = 1;
		for(String s:directorios){
			GatewayConfiguracion.setearDirectorio(s, i);
			i++;
		}
		CargadorArchivos plugin = new CargadorArchivos();
		plugin.cargarEstadosBatch(GatewayConfiguracion.getDirectorio(3));
	}
}
