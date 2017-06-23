package viverbot.Vista;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class VistaPrincipalTest {

	VistaPrincipal vista;

	@Test
	public void testActualizarVistaDiagnosticoOptimo() {
		this.inicializar();
		Medicion temp = new Medicion(10.0, Magnitudes.TEMPERATURA);
		DiagnosticoAnalisis d = new DiagnosticoAnalisis(temp, true,0.0);
		vista.ActualizarVista(d);
		assertEquals(vista.getLabelEstado().getText(), "La temperatura está dentro del rango ideal");
		assertEquals(vista.getLabelEstadoSensor().getText(), "El sensor esta inactivo. Ejecutando simulacion");
		assertEquals(vista.getLabelTemperatura().getText(), "La temperatura actual es: 10.0 ºC");
		this.clear();
	}

	@Test
	public void testActualizarVistaDiagnosticoAlto() {
		this.inicializar();
		Medicion temp = new Medicion(10.0, Magnitudes.TEMPERATURA);
		DiagnosticoAnalisis d = new DiagnosticoAnalisis(temp, false,5.0);
		vista.ActualizarVista(d);
		assertEquals(vista.getLabelEstado().getText(), "La temperatura está por encima del rango ideal por 5.0 ºC");
		assertEquals(vista.getLabelEstadoSensor().getText(), "El sensor esta inactivo. Ejecutando simulacion");
		assertEquals(vista.getLabelTemperatura().getText(), "La temperatura actual es: 10.0 ºC");
		this.clear();
	}

	@Test
	public void testActualizarVistaDiagnosticoBajo() {
		this.inicializar();
		Medicion temp = new Medicion(10.0, Magnitudes.TEMPERATURA);
		DiagnosticoAnalisis d = new DiagnosticoAnalisis(temp, false,-5.0);
		vista.ActualizarVista(d);
		assertEquals(vista.getLabelEstado().getText(), "La temperatura está por debajo del rango ideal por -5.0 ºC");
		assertEquals(vista.getLabelEstadoSensor().getText(), "El sensor esta inactivo. Ejecutando simulacion");
		assertEquals(vista.getLabelTemperatura().getText(), "La temperatura actual es: 10.0 ºC");
		this.clear();
	}



	private void inicializar() {
		vista = new VistaPrincipal(null);
	}

	private void clear() {
		this.vista = null;
	}
}
