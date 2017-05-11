package viverbot.Model.Medicion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;

public class AutomatizadorDeClimaTest {

	@Test
	public void verificarRango_recibeRangoValido_devuelveTrue() throws Exception {
		Temperatura tempValida = new Temperatura(18.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizadorValido = new AutomatizadorDeClima(tempValida, rango);
		boolean type = Whitebox.invokeMethod(automatizadorValido, "verificarRango");
		assertTrue(type);
	}

	@Test
	public void verificarRango_recibeRangoInvalido_devuelveFalse() throws Exception {
		Temperatura tempInvalida = new Temperatura(25.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizadorInvalido = new AutomatizadorDeClima(tempInvalida, rango);
		boolean type = Whitebox.invokeMethod(automatizadorInvalido, "verificarRango");
		assertFalse(type);
	}

}
