package viverbot.Controlador;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;

import org.junit.Test;

import viverbot.Modelo.Medicion.AireAcondicionado;
import viverbot.Modelo.Medicion.Calor;
import viverbot.Modelo.Medicion.Frio;
import viverbot.Modelo.Medicion.Potencia_0;
import viverbot.Modelo.Medicion.Potencia_1;

public class ControlManualAireVistaControllerTest {
	private ControlManualAireVistaController controlador;
	private AireAcondicionado aire;

	@Test
	public void cerrar_test() {
		init();
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getBtn_cerrar(), 0, ""));
		clear();
	}
	
	@Test
	public void encenderAireTest(){
		init();
		aire.encender();
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getBtn_encenderAire(), 0, ""));
		clear();
	}
	
	@Test
	public void apagarAireTest(){
		init();
		controlador.getVista().getDropdown_friocalor().setSelectedIndex(0);
		controlador.getVista().getDropdown_potencia().setSelectedIndex(0);
		controlador.getVista().getDropdown_temperatura().setSelectedIndex(0);
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getBtn_encenderAire(), 0, ""));
		assertEquals(new Calor().getClass(), aire.getEstado().getClass());
		assertEquals(new Potencia_0().getClass(), aire.getPotencia().getClass());
		assertEquals("16", aire.getTemp().toString());
		clear();
	}
	
	@Test
	public void guardarTest(){
		init();
		controlador.getVista().getDropdown_friocalor().setSelectedIndex(1);
		controlador.getVista().getDropdown_potencia().setSelectedIndex(1);
		controlador.getVista().getDropdown_temperatura().setSelectedIndex(1);
		controlador.actionPerformed(new ActionEvent(controlador.getVista().getBtn_guardar(), 0, ""));
		assertEquals(new Frio().getClass(), aire.getEstado().getClass());
		assertEquals(new Potencia_1().getClass(), aire.getPotencia().getClass());
		assertEquals("17", aire.getTemp().toString());
		clear();
	}

	public void init() {
		this.aire = new AireAcondicionado();
		this.controlador = new ControlManualAireVistaController(aire);
	}

	public void clear(){
		this.aire = null;
		this.controlador = null;
	}

}
