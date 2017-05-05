package viverbot.Controller.Verificacion;

import static org.junit.Assert.*;

import org.junit.Test;

import viverbot.Controlador.Verificacion.TransmisorTemperaturaActual;
import viverbot.Model.Ambiente;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class TransmisorTemperaturaActualTest {

	TransmisorTemperaturaActual trasnmisorTest = null;
	Thread hilo = null;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertTrue(this.trasnmisorTest.getTemperaturaActual() != null);

		this.clear();
	}


	@Test
	public void enviarDatoTest() {
		this.inicialize();

		Temperatura t = new Temperatura(20.0);
		Ambiente a = Ambiente.getInstance();
		a.setTemperatura(t);
		
		Temperatura e=new Temperatura(this.trasnmisorTest.mediador.getInstrumentoMedicion().getMedicion().getValor());
		assertTrue(e.equals(t));
		this.clear();
	}
	

	// metodos auxiliares
	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperaturaActual();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}

}
