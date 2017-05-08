package viverbot.Modelo.Simulacion;

import java.util.HashMap;
import java.util.Map;

import viverbot.Interfaces.ISimularMedicion;
import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class Simulador implements ISimularMedicion {

	private Map<Horario, RangoNumerico> rangos;
	private Magnitudes magnitud;

	public Simulador(Map<Horario, RangoNumerico> r, Magnitudes m ) {
		this.rangos = r;
		magnitud = m; 
	}

	

	@Override
	public Medicion getMedicion(Hora actual) {
		RangoNumerico r = this.rangos.get(Horario.getHorario(actual));
		return new Medicion(Math.random() * (r.getMaximo()-r.getMinimo()) + r.getMinimo(), this.magnitud);

	}

}
