package viverbot.Modelo.Monitoreo;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Model.EstadoVivero;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;
import viverbot.Modelo.Medicion.MedicionVacioException;

public class MonitorTemperaturaTest {
	private MonitorEstado monitor;

	

	@Test
	public void testGetTemperaturaActual() {
		this.inicializar();
		EstadoVivero estado = EstadoVivero.getInstance();
		estado.addObserver(this.monitor);
		Medicion temp = new Medicion(10.0, Magnitud.TEMPERATURA);
		estado.setTemperaturaColector(temp);
		assertEquals(this.monitor.getUltimaMedicion(), temp);
		this.clear();
	}

	@Test
	public void testSetTemperaturaActual() {
		this.inicializar();
		Medicion temp = new Medicion(10.0, Magnitud.TEMPERATURA);

		this.monitor.setTemperaturaActual(temp);
		assertEquals(this.monitor.getUltimaMedicion(), new Medicion(10.0, Magnitud.TEMPERATURA));
	}

	@Test
	public void testMonitorearOptimo() throws MedicionVacioException {
		this.inicializar();
		Medicion temp = new Medicion(10.0, Magnitud.TEMPERATURA);
		EstadoVivero.getInstance().setRangoTemperatura(new RangoNumerico(5.0, 15.0));
		DiagnosticoAnalisis d = this.monitor.monitorear(temp);
		assertTrue(d.getOptima());
		assertEquals(this.monitor.getUltimaMedicion(), temp);
		assertEquals(d.getDiferencia(), new Double(0.0));
	}
	
	@Test
	public void testMonitorearAlta() throws MedicionVacioException {
		this.inicializar();
		Medicion temp = new Medicion(10.0, Magnitud.TEMPERATURA);
		EstadoVivero.getInstance().setRangoTemperatura(new RangoNumerico(5.0, 8.0));
		DiagnosticoAnalisis d = this.monitor.monitorear(temp);
		assertFalse(d.getOptima());
		assertEquals(this.monitor.getUltimaMedicion(), temp);
		assertEquals(d.getDiferencia(), new Double(2.0));
	}
	
	@Test
	public void testMonitorearBaja() throws MedicionVacioException {
		this.inicializar();
		Medicion temp = new Medicion(10.0, Magnitud.TEMPERATURA);
		EstadoVivero.getInstance().setRangoTemperatura(new RangoNumerico(15.0, 20.0));
		DiagnosticoAnalisis d = this.monitor.monitorear(temp);
		assertFalse(d.getOptima());
		assertEquals(this.monitor.getUltimaMedicion(), temp);
		assertEquals(d.getDiferencia(), new Double(-5.0));
	}

	private void inicializar() {
		this.monitor = new MonitorEstado();

	}

	private void clear() {
		this.monitor = null;
	}

}
