package viverbot.Model.Medicion;

import java.util.Timer;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;

public class AutomatizadorDeClimaTest {

	public static void main(String[] args) {
		Temperatura temp = new Temperatura(21.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		Timer timer = new Timer();
		timer.schedule(automatizacion.tt, 1000, 1000);
	}

}
