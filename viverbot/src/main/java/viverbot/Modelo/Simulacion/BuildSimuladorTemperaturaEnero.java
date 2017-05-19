package viverbot.Modelo.Simulacion;

import java.util.HashMap;
import java.util.Map;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class BuildSimuladorTemperaturaEnero implements IBuildSimulador {

	private static final Simulador s = new Simulador(inicializarRangos(), Magnitudes.TEMPERATURA, 300000);

	@Override
	public Simulador getSimulador() {
		return s;
	}

	private static Map<Horario, RangoNumerico> inicializarRangos() {
		Map<Horario, RangoNumerico> r = new HashMap<Horario, RangoNumerico>();
		r.put(Horario.MEDIANOCHE, new RangoNumerico(15.0, 19.0));
		r.put(Horario.MADRUGADA, new RangoNumerico(10.0, 17.0));
		r.put(Horario.AMANECER, new RangoNumerico(15.0, 20.0));
		r.put(Horario.MAÑANA, new RangoNumerico(18.0, 25.0));
		r.put(Horario.MEDIODIA, new RangoNumerico(25.0, 32.0));
		r.put(Horario.TARDE, new RangoNumerico(27.0, 35.0));
		r.put(Horario.ATARDECER, new RangoNumerico(20.0, 30.0));
		r.put(Horario.NOCHE, new RangoNumerico(17.0, 25.0));
		return r;
	}

}
