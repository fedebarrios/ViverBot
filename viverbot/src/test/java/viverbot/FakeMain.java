package viverbot;

import viverbot.Controlador.AutomatizadorVistaController;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;

public class FakeMain {

	public static void main(String[] args) {
		Temperatura temp = new Temperatura(25.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		AutomatizadorVistaController vista = new AutomatizadorVistaController(automatizacion);
		
	}

}
