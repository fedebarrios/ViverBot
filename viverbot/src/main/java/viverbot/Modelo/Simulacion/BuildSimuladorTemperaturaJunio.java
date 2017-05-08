package viverbot.Modelo.Simulacion;

import java.util.HashMap;
import java.util.Map;

import viverbot.Interfaces.ISimularMedicion;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class BuildSimuladorTemperaturaJunio implements IBuildMedir {

	private static final Map<Horario, RangoNumerico> rangos = inicializarRangos();

	@Override
	public ISimularMedicion getSimulador() {
		ISimularMedicion s = new Simulador(rangos, Magnitudes.TEMPERATURA);
		return s;
	}

	private static Map<Horario, RangoNumerico> inicializarRangos() {
		Map<Horario, RangoNumerico> r = new HashMap<Horario, RangoNumerico>();
		r.put(Horario.MEDIANOCHE, new RangoNumerico(5.0, 0.0));
		r.put(Horario.MADRUGADA, new RangoNumerico(0.0, 5.0));
		r.put(Horario.AMANECER, new RangoNumerico(5.0, 10.0));
		r.put(Horario.MAÑANA, new RangoNumerico(10.0, 15.0));
		r.put(Horario.MEDIODIA, new RangoNumerico(15.0, 20.0));
		r.put(Horario.TARDE, new RangoNumerico(20.0, 15.0));
		r.put(Horario.ATARDECER, new RangoNumerico(15.0, 10.0));
		r.put(Horario.NOCHE, new RangoNumerico(10.0, 5.0));
		return r;
	}


}
