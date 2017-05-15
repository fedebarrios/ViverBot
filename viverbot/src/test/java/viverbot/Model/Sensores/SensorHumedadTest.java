package viverbot.Model.Sensores;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.Model.EstadoVivero;
import viverbot.Model.Hora;
import viverbot.Modelo.Magnitudes.Humedad;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Sensores.SensorHumedad;

public class SensorHumedadTest {

	SensorHumedad sensorTest = null;

	@Test
	public void verificarClaseTest() {
		inicialize();
		assertEquals(sensorTest.getMedicion().getTipo(), Magnitudes.HUMEDAD);
		clear();
	}

	@Test
	public void testGetMedicion() {
		inicialize();

		EstadoVivero ambienteSimulado = EstadoVivero.getInstance();

		assertTrue(this.verificarHumedad(this.getHorarios(), ambienteSimulado));
		clear();
	}
	// metodos auxiliares

	
	
	private boolean verificarHumedad(ArrayList<Hora> horarios, EstadoVivero a) {
		boolean ret = true;
		for (Hora h : horarios) {
			a.setHoraActual(h);
			assertTrue(this.sensorTest.getMedicion().getValor() >= 0);
			ret = ret && sensorTest.getMedicion().equals(a.getHumedad());
		}
		return ret;
	}


	private void clear() {
		this.sensorTest = null;
	}

	private void inicialize() {
		this.sensorTest = new SensorHumedad();
	}
	
	private ArrayList<Hora> getHorarios() {
		Hora amanecer = new Hora(6, 0, 0);
		Hora mañana = new Hora(9, 0, 0);
		Hora medioDia = new Hora(12, 0, 0);
		Hora tarde = new Hora(15, 0, 0);
		Hora atardecer = new Hora(18, 0, 0);
		Hora noche = new Hora(21, 0, 0);
		Hora mediaNoche = new Hora(24, 0, 0);
		Hora madrugada = new Hora(3, 0, 0);

		ArrayList<Hora> horarios = new ArrayList<Hora>();
		horarios.add(amanecer);
		horarios.add(mañana);
		horarios.add(medioDia);
		horarios.add(tarde);
		horarios.add(atardecer);
		horarios.add(noche);
		horarios.add(mediaNoche);
		horarios.add(madrugada);
		return horarios;

	}

}
