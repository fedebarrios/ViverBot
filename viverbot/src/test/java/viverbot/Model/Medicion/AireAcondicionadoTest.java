package viverbot.Model.Medicion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import viverbot.Model.RangoNumerico;
import viverbot.Model.Magnitudes.Temperatura;
import viverbot.Model.Medicion.AireAcondicionado;

public class AireAcondicionadoTest {

	@Test
	public void interferirTemperatura_recibeTemperatura0_modificaLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		Temperatura expected = new Temperatura(20.45);
		Temperatura temp = new Temperatura(20.5);
		aire.establecerPotenciaYEstado(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		assertEquals(expected.getValor(), temp.getValor());
	}

	@Test
	public void interferirTemperatura_recibeTemperatura1_modificaLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		Temperatura expected = new Temperatura(21.0);
		Temperatura temp = new Temperatura(21.1);
		aire.establecerPotenciaYEstado(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		assertEquals(expected.getValor(), temp.getValor());
	}

	@Test
	public void interferirTemperatura_recibeTemperatura2_modificaLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		Temperatura expected = new Temperatura(22.65);
		Temperatura temp = new Temperatura(22.8);
		aire.establecerPotenciaYEstado(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		Double actual = Math.rint(temp.getValor() * 100) / 100;
		assertEquals(expected.getValor(), actual);
	}

	@Test
	public void interferirTemperatura_recibeTemperatura3_modificaLaTemperatura() {
		AireAcondicionado aire = new AireAcondicionado();
		Temperatura expected = new Temperatura(24.3);
		Temperatura temp = new Temperatura(24.5);
		aire.establecerPotenciaYEstado(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		assertEquals(expected.getValor(), temp.getValor());
	}

}
