package viverbot.Controlador;

import static org.junit.Assert.*;


import org.junit.Test;

import viverbot.MockOptionPane;
import viverbot.Archivos.CargadorEstadosAltura;
import viverbot.Archivos.GatewayConfiguracion;

public class ControladorAnalizadorAlturaTest {
	ControladorAnalizadorAltura controlador;
	
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
		GatewayConfiguracion.limpiar();
		String[] directorios = {"src/test/java/viverbot/Archivos/DirectorioTest1",
				"src/test/java/viverbot/Archivos/DirectorioTest2",
				"src/test/java/viverbot/Archivos/EstadosAlturaFiles"};
		int i = 1;
		for(String s:directorios){
			GatewayConfiguracion.agregarDirectorio(s);
			i++;
		}
		CargadorEstadosAltura plugin = new CargadorEstadosAltura();
		plugin.cargarEstadosBatch(GatewayConfiguracion.getDirectorio(2));
	}
}
