package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Simulacion.Simulador;

import java.util.HashMap;
import java.util.Map;

public class InstrumentoFactory {

	

	private static final Map<Magnitud, Medir> sensores = inicializar();

	public static Medir crearInstrumento(Magnitud m) {
		return sensores.get(m);
	}

	private static Map<Magnitud, Medir> inicializar() {

		Map<Magnitud, Medir> s = new HashMap<Magnitud, Medir>();
		s.put(Magnitud.TEMPERATURA, new SensorTemperatura());
		s.put(Magnitud.HUMEDAD, new SensorHumedad());
		s.put(Magnitud.ALTURA, new Metro());
		s.put(Magnitud.VACIO, new UnknowInstrumentoMedicion());
	
		

		return s;
	}

}
