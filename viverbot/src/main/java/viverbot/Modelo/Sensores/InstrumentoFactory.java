package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Simulacion.Simulador;

import java.util.HashMap;
import java.util.Map;

public class InstrumentoFactory {

	

	private static final Map<Magnitudes, Medir> sensores = inicializar();

	public static Medir crearInstrumento(Magnitudes m) {
		return sensores.get(m);
	}

	private static Map<Magnitudes, Medir> inicializar() {

		Map<Magnitudes, Medir> s = new HashMap<Magnitudes, Medir>();
		s.put(Magnitudes.TEMPERATURA, new SensorTemperatura());
		s.put(Magnitudes.HUMEDAD, new SensorHumedad());
		s.put(Magnitudes.ALTURA, new Metro());
		s.put(Magnitudes.VACIO, new UnknowInstrumentoMedicion());
	
		

		return s;
	}

}
