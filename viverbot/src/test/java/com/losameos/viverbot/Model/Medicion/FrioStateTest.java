package com.losameos.viverbot.Model.Medicion;

import static org.junit.Assert.*;
import org.junit.Test;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class FrioStateTest {

	@Test
	public void interferirEnElClimaTest_recibePotencia0_devuelveTempAumentadaEnPotencia0() {
		FrioState frio = new FrioState();
		Temperatura expected = new Temperatura(14.95);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia0Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}

	@Test
	public void interferirEnElClimaTest_recibePotencia1_devuelveTempAumentadaEnPotencia1() {
		FrioState frio = new FrioState();
		Temperatura expected = new Temperatura(14.90);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia1Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}

	@Test
	public void interferirEnElClimaTest_recibePotencia2_devuelveTempAumentadaEnPotencia2() {
		FrioState frio = new FrioState();
		Temperatura expected = new Temperatura(14.85);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia2Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}

	@Test
	public void interferirEnElClimaTest_recibePotencia3_devuelveTempAumentadaEnPotencia3() {
		FrioState frio = new FrioState();
		Temperatura expected = new Temperatura(14.8);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia3Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}

}
