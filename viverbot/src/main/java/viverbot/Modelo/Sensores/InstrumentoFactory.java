package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitudes;

import java.util.HashMap;
import java.util.Map;


public class InstrumentoFactory {
	
	private static final Map<Magnitudes, InstrumentoMedicion> sensores= inicializar();

	public static InstrumentoMedicion crearInstrumento(Magnitudes m) {
		return sensores.get(m);
	}
	
	private static Map<Magnitudes, InstrumentoMedicion> inicializar(){
		
		Map<Magnitudes, InstrumentoMedicion> s = new HashMap<Magnitudes, InstrumentoMedicion>();
		s.put(Magnitudes.TEMPERATURA, new SensorTemperatura());
		s.put(Magnitudes.HUMEDAD, new SensorHumedad());
		s.put(Magnitudes.ALTURA, new Metro());
		s.put(Magnitudes.VACIO, new UnknowInstrumentoMedicion());

		return s;
	}

	


}
