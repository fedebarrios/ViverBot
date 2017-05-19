package viverbot.Controlador;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

import viverbot.Modelo.Medicion.AutomatizadorDeClima;

public class AutomatizadorVistaControllerTest {
	private AutomatizadorVistaController controlador;
	private AutomatizadorDeClima automatizador;

	@Test
	public void cargarCamposTest_apagado() {
		init();
		assertEquals("Apagado", controlador.getVista().getLabel_textencendidoAutomatizador().getText());
		clear();
	}
	
	@Test
	public void cargarCamposTest_encendido() {
		init_encendido();
		assertEquals("Encendido", controlador.getVista().getLabel_textencendidoAutomatizador().getText());
		assertEquals("Apagado", controlador.getVista().getLabel_textcontrolManual().getText());
		assertEquals("Frio", controlador.getVista().getLabel_textestado().getText());
		assertEquals("0", controlador.getVista().getLabel_textpotencia().getText());
		assertEquals("24", controlador.getVista().getLabel_texttemperaturaAire().getText());
		clear();
	}

	@Test
	public void cargarCamposTest_encendidoManualmente() throws InterruptedException {
		init_encendidoManualmente();
		assertEquals("Apagado", controlador.getVista().getLabel_textencendidoAutomatizador().getText());
		assertTrue(controlador.getAutomatizador().getAire().isEncendidoManualmente());
//		assertEquals("Encendido", automatizadorVista.getVista().getLabel_textcontrolManual().getText());
//		assertEquals("Frio", automatizadorVista.getVista().getLabel_textestado().getText());
//		assertEquals("0", automatizadorVista.getVista().getLabel_textpotencia().getText());
//		assertEquals("24", automatizadorVista.getVista().getLabel_texttemperaturaAire().getText());
		clear();
	}

	@Test
	public void cerrar_test() {
		init();
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getMenuitem_salir(), 0, ""));
		clear();
	}
	
	@Test
	public void abrirConfiguracionManual_test() {
		init();
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getMenuitem_configuracionManual(), 0, ""));
		clear();
	}
	
	@Test
	public void encenderAutomatizador_test() {
		init();
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getMenuitem_onOffAutomatizador(), 0, ""));
		assertTrue(automatizador.isEncendido());
		clear();
	}
	
	@Test
	public void apagarAutomatizador_test() {
		init_encendido();
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getMenuitem_onOffAutomatizador(), 0, ""));
		assertFalse(automatizador.isEncendido());
		assertEquals("", controlador.getVista().getLabel_textestado().getText());
		assertEquals("", controlador.getVista().getLabel_textpotencia().getText());
		assertEquals("", controlador.getVista().getLabel_texttemperaturaAire().getText());
		clear();
	}
	
	public void init_encendido() {
		this.automatizador = new AutomatizadorDeClima();
		automatizador.encender();
		this.controlador = new AutomatizadorVistaController(automatizador);
	}
	
	public void init_encendidoManualmente(){
		this.automatizador = new AutomatizadorDeClima();
		this.controlador = new AutomatizadorVistaController(automatizador);
		controlador.getAutomatizador().getAire().encender();
	}
	
	public void init() {
		this.automatizador = new AutomatizadorDeClima();
		this.controlador = new AutomatizadorVistaController(automatizador);
	}

	public void clear() {
		this.automatizador = null;
		this.controlador = null;
	}

}
