package viverbot.Modelo.Simulacion;

import java.util.HashMap;
import java.util.Map;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class BuildSimuladorTemperaturaJunio implements IBuildSimulador {

	private static final Simulador s = new Simulador(inicializarRangos(), Magnitudes.TEMPERATURA,300000);

	@Override
	public Simulador getSimulador() {
		return s;
	}

	private static Map<Horario, RangoNumerico> inicializarRangos() {
		Map<Horario, RangoNumerico> r = new HashMap<Horario, RangoNumerico>();
		r.put(Horario.MEDIANOCHE, new RangoNumerico(0.0, 0.5));
		r.put(Horario.MADRUGADA, new RangoNumerico(2.0, 7.0));
		r.put(Horario.AMANECER, new RangoNumerico(5.0, 10.0));
		r.put(Horario.MAÑANA, new RangoNumerico(7.0, 15.0));
		r.put(Horario.MEDIODIA, new RangoNumerico(10.0, 17.0));
		r.put(Horario.TARDE, new RangoNumerico(7.0, 15.0));
		r.put(Horario.ATARDECER, new RangoNumerico(5.0, 10.0));
		r.put(Horario.NOCHE, new RangoNumerico(2.0, 7.0));
		return r;
	}


}
