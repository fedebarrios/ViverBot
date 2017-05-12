package viverbot;

import java.util.Timer;

import viverbot.Controlador.AutomatizacionController;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AutomatizadorDeClima;

public class FakeMain {

	public static void main(String[] args) {
		Temperatura temp = new Temperatura(23.0);
		RangoNumerico rango = new RangoNumerico(15.0, 20.0);
		AutomatizadorDeClima automatizacion = new AutomatizadorDeClima(temp, rango);
		automatizacion.encenderApagarAutomatizador(true);
		AutomatizacionController vista = new AutomatizacionController(automatizacion);
		
	}

}
