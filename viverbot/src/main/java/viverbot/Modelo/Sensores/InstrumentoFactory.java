package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Simulacion.Simulador;

import java.util.HashMap;
import java.util.Map;

public class InstrumentoFactory {

	private static final String rangosEnero = "#15,19#10,17#15,20#18,25#25,32#27,35#20,30#17,25#";
	private static final String rangosJunio = "#00,05#02,07#05,10#07,15#10,17#07,15#05,10#02,07#";
	private static final long frecuencia = 300000;

	private static final Map<Magnitudes, IMedir> sensores = inicializar();

	public static IMedir crearInstrumento(Magnitudes m) {
		return sensores.get(m);
	}

	private static Map<Magnitudes, IMedir> inicializar() {

		Map<Magnitudes, IMedir> s = new HashMap<Magnitudes, IMedir>();
		s.put(Magnitudes.TEMPERATURA, new SensorTemperatura());
		s.put(Magnitudes.HUMEDAD, new SensorHumedad());
		s.put(Magnitudes.ALTURA, new Metro());
		s.put(Magnitudes.VACIO, new UnknowInstrumentoMedicion());
		s.put(Magnitudes.TEMPERATURA_SIMULADA_ENERO, new Simulador(Simulador.inicializarRangos(rangosEnero),
				Magnitudes.TEMPERATURA_SIMULADA_ENERO, frecuencia));
		s.put(Magnitudes.TEMPERATURA_SIMULADA_JUNIO, new Simulador(Simulador.inicializarRangos(rangosEnero),
				Magnitudes.TEMPERATURA_SIMULADA_JUNIO, frecuencia));
		

		return s;
	}

}
