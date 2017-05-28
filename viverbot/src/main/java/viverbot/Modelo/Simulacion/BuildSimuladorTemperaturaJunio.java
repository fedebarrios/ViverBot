package viverbot.Modelo.Simulacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class BuildSimuladorTemperaturaJunio implements IBuildSimulador {

	private static final Simulador s = new Simulador(inicializarRangos(), Magnitudes.TEMPERATURA, 300000);
	private static final String rangos = "#00,05#02,07#05,10#07,15#10,17#07,15#05,10#02,07#";

	@Override
	public Simulador getSimulador() {
		return s;
	}

	private static Map<Horario, RangoNumerico> inicializarRangos() {
		Map<Horario, RangoNumerico> r = new HashMap<Horario, RangoNumerico>();
		ArrayList<RangoNumerico> rango = RangoNumerico.parseRangoNumerico(rangos);
		Horario[] horarios = Horario.values();
		for (int i = 0; i < horarios.length; i++) {
			r.put(horarios[i], rango.get(i));
		}

		return r;
	}

}
