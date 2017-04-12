package com.losameos.viverbot.Model.Medicion;

import static org.junit.Assert.*;
import org.junit.Test;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class CalorStateTest {

	@Test
	public void interferirEnElClimaTest_recibePotencia0_devuelveTempAumentadaEnPotencia0() {
		CalorState frio = new CalorState();
		Temperatura expected = new Temperatura(15.05);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia0Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}

	@Test
	public void interferirEnElClimaTest_recibePotencia1_devuelveTempAumentadaEnPotencia1() {
		CalorState frio = new CalorState();
		Temperatura expected = new Temperatura(15.1);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia1Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}

	@Test
	public void interferirEnElClimaTest_recibePotencia2_devuelveTempAumentadaEnPotencia2() {
		CalorState frio = new CalorState();
		Temperatura expected = new Temperatura(15.15);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia2Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}

	@Test
	public void interferirEnElClimaTest_recibePotencia3_devuelveTempAumentadaEnPotencia3() {
		CalorState frio = new CalorState();
		Temperatura expected = new Temperatura(15.2);
		Temperatura actual = frio.interferirEnElClima(new Temperatura(15.0), new Potencia3Strategy());
		assertEquals(expected.getValor(), actual.getValor());
	}
}
