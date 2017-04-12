package com.losameos.viverbot.Model.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AireAcondicionadoStateTest {

	@Test
	public void interferirTemperatura_recibeTemperatura0_modificaLaTemperatura() {
		AireAcondicionadoState aire = new AireAcondicionadoState();
		aire.frioState();
		Temperatura expected = new Temperatura(20.45);
		Temperatura temp = new Temperatura(20.5);
		aire.estableceCalculadorDePotencia(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		assertEquals(expected.getValor(), temp.getValor());
	}
	
	@Test
	public void interferirTemperatura_recibeTemperatura1_modificaLaTemperatura() {
		AireAcondicionadoState aire = new AireAcondicionadoState();
		aire.frioState();
		Temperatura expected = new Temperatura(21.0);
		Temperatura temp = new Temperatura(21.1);
		aire.estableceCalculadorDePotencia(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		assertEquals(expected.getValor(), temp.getValor());
	}
	
	@Test
	public void interferirTemperatura_recibeTemperatura2_modificaLaTemperatura() {
		AireAcondicionadoState aire = new AireAcondicionadoState();
		aire.frioState();
		Temperatura expected = new Temperatura(22.65);
		Temperatura temp = new Temperatura(22.8);
		aire.estableceCalculadorDePotencia(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		Double actual = Math.rint(temp.getValor()*100)/100;
		assertEquals(expected.getValor(), actual);
	}
	
	@Test
	public void interferirTemperatura_recibeTemperatura3_modificaLaTemperatura() {
		AireAcondicionadoState aire = new AireAcondicionadoState();
		aire.frioState();
		Temperatura expected = new Temperatura(24.3);
		Temperatura temp = new Temperatura(24.5);
		aire.estableceCalculadorDePotencia(temp, new RangoNumerico(15.0, 20.0));
		aire.interferirTemperatura(temp);
		assertEquals(expected.getValor(), temp.getValor());
	}

}
