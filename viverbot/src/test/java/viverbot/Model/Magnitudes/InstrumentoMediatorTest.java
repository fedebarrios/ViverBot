package viverbot.Model.Magnitudes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import viverbot.DTO.Planta;
import viverbot.DTO.UbicacionDTO;
import viverbot.Model.EstadoVivero;
import viverbot.Model.Fecha;
import viverbot.Model.Hora;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.InstrumentoMediator;
import viverbot.Modelo.Sensores.SensorHumedad;
import viverbot.Modelo.Sensores.SensorTemperatura;
import viverbot.Modelo.Simulacion.Simulador;

public class InstrumentoMediatorTest {

	InstrumentoMediator mediatorTest = null;
	private static final String rangos = "#15,19#10,17#15,20#18,25#25,32#27,35#20,30#17,25#";
	
	

	@Test
	public void colectorMagnitudesTestTemperatura() {
		this.mediatorTest = new InstrumentoMediator(Magnitudes.TEMPERATURA);
		assertTrue(this.mediatorTest.getInstrumentoMedicion().getClass() == SensorTemperatura.class);
		this.clear();
	}

	@Test
	public void colectorMagnitudesTestHumedad() {
		this.mediatorTest = new InstrumentoMediator(Magnitudes.HUMEDAD);
		assertTrue(this.mediatorTest.getInstrumentoMedicion() instanceof SensorHumedad);
		
		
		this.clear();
	}

	@Test
	public void testTomarMedicionTemperatura() {
		this.mediatorTest = new InstrumentoMediator(Magnitudes.TEMPERATURA);
		SensorTemperatura s = (SensorTemperatura) this.mediatorTest.getInstrumentoMedicion();
		Medicion medicion = new Medicion(5.0, Magnitudes.TEMPERATURA);
		EstadoVivero.getInstance().setTemperaturaActual(medicion);
		assertEquals(medicion, this.mediatorTest.tomarMedicion());
		assertEquals(this.mediatorTest.tomarMedicion().getTipo(), Magnitudes.TEMPERATURA);

		clear();

	}
	
	@Test
	public void testTomarMedicionHumedad() {
		this.mediatorTest = new InstrumentoMediator(Magnitudes.HUMEDAD);
		EstadoVivero ambienteSimulado = EstadoVivero.getInstance();
		assertTrue(this.verificarHumedad(this.getHorarios(), ambienteSimulado));
		assertTrue(this.mediatorTest.tomarMedicion().getTipo() == Magnitudes.HUMEDAD);

		clear();

	}
	
	@Test
	public void TomarAltura() {
		this.mediatorTest = new InstrumentoMediator(Magnitudes.ALTURA);
		Planta p = new Planta(1, 10, new UbicacionDTO(1,5,4), new Fecha(04, 05, 2017));
		assertEquals(Magnitudes.ALTURA , mediatorTest.tomarAltura(p).getTipo());
		this.clear();
	}	

	// metodos auxiliares
	private void clear() {
		this.mediatorTest = null;

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

	
	
	private boolean verificarHumedad(ArrayList<Hora> horarios, EstadoVivero a) {
		boolean ret = true;
		for (Hora h : horarios) {
			a.setHoraActual(h);
			ret = ret && mediatorTest.tomarMedicion().equals(a.getHumedadActual());
		}
		return ret;
	}

}
