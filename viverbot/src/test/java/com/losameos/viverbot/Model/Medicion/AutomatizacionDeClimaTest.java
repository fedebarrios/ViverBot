package com.losameos.viverbot.Model.Medicion;

import java.util.Timer;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AutomatizacionDeClimaTest {

	public static void main(String[] args) {
		Temperatura temp = new Temperatura(21.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizacionDeClima automatizacion = new AutomatizacionDeClima(temp, rango);
		Timer timer = new Timer();
		timer.schedule(automatizacion.tt, 1000, 1000);
	}

}
