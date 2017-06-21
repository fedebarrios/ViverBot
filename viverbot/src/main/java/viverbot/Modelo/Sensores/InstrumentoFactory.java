package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitudes;

import java.util.HashMap;
import java.util.Map;


public class InstrumentoFactory {
	
	private static final Map<Magnitudes, IMedir> sensores= inicializar();

	public static IMedir crearInstrumento(Magnitudes m) {
		return sensores.get(m);
	}
	
	private static Map<Magnitudes, IMedir> inicializar(){
		
		Map<Magnitudes, IMedir> s = new HashMap<Magnitudes, IMedir>();
		s.put(Magnitudes.TEMPERATURA, new SensorTemperatura());
		s.put(Magnitudes.HUMEDAD, new SensorHumedad());
		s.put(Magnitudes.ALTURA, new Metro());
		s.put(Magnitudes.VACIO, new UnknowInstrumentoMedicion());

		return s;
	}

	


}
