package viverbot.Model.Medicion;

import java.util.Timer;

import viverbot.Model.RangoNumerico;
import viverbot.Model.Magnitudes.Temperatura;
import viverbot.Model.Medicion.AutomatizacionDeClima;

public class AutomatizacionDeClimaTest {

	public static void main(String[] args) {
		Temperatura temp = new Temperatura(21.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizacionDeClima automatizacion = new AutomatizacionDeClima(temp, rango);
		Timer timer = new Timer();
		timer.schedule(automatizacion.tt, 1000, 1000);
	}

}
