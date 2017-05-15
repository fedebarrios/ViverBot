package viverbot;

import viverbot.Controlador.AutomatizadorVistaController;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;

public class FakeMain {

	public static void main(String[] args) {
		Medicion temp = new Medicion(25.0, Magnitudes.TEMPERATURA);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		AutomatizadorVistaController vista = new AutomatizadorVistaController(automatizacion);
		
	}

}
