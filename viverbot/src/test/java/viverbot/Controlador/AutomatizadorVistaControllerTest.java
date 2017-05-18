package viverbot.Controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Medicion.AutomatizadorDeClima;

public class AutomatizadorVistaControllerTest {
	private AutomatizadorVistaController automatizadorVista;
	private AutomatizadorDeClima automatizador;

	@Test
	public void cargarCamposTest_apagado() {
		init_apagado();
		assertEquals("Apagado", automatizadorVista.getVista().getLabel_textencendidoAutomatizador().getText());
		clear();
	}
	
	@Test
	public void cargarCamposTest_encendido() {
		init_encendido();
		assertEquals("Encendido", automatizadorVista.getVista().getLabel_textencendidoAutomatizador().getText());
		assertEquals("Apagado", automatizadorVista.getVista().getLabel_textcontrolManual().getText());
		assertEquals("Frio", automatizadorVista.getVista().getLabel_textestado().getText());
		assertEquals("0", automatizadorVista.getVista().getLabel_textpotencia().getText());
		assertEquals("24", automatizadorVista.getVista().getLabel_texttemperaturaAire().getText());
		clear();
	}

	public void init_encendido() {
		this.automatizador = new AutomatizadorDeClima();
		automatizador.encender();
		this.automatizadorVista = new AutomatizadorVistaController(automatizador);
	}
	
	public void init_apagado() {
		this.automatizador = new AutomatizadorDeClima();
		this.automatizadorVista = new AutomatizadorVistaController(automatizador);
	}

	public void clear() {
		this.automatizador = null;
		this.automatizadorVista = null;
	}

}
