package com.losameos.viverbot.Model.Medicion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.losameos.viverbot.Controller.Verificacion.TransmisorTemperatura;
import com.losameos.viverbot.Model.Ambiente;
import com.losameos.viverbot.Model.Hora;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.ColectorTemperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class TransmisorTemperaturaTest {

	TransmisorTemperatura trasnmisorTest = null;

	@Test
	public void transmisorTest() {
		this.inicialize();
		assertNotNull(this.trasnmisorTest.getAnalizador());
		this.clear();
	}

	// metodos auxiliares
	private void inicialize() {
		this.trasnmisorTest = new TransmisorTemperatura();
	}

	private void clear() {
		this.trasnmisorTest = null;
	}

}
