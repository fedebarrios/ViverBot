package viverbot.Modelo.Simulacion;

import java.util.HashMap;
import java.util.Map;

import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class Simulador {

	private Map<Horario, RangoNumerico> rangos;
	private Magnitudes magnitud;
	private Hora horaActual;

	public Simulador(Map<Horario, RangoNumerico> r, Magnitudes m) {
		this.rangos = r;
		magnitud = m;
		this.horaActual = Hora.obtenerHoraActual();
	}

	public Medicion getMedicion(Hora actual) {
		RangoNumerico r = this.rangos.get(Horario.getHorario(this.horaActual));
		return new Medicion(Math.random() * (r.getMaximo() - r.getMinimo()) + r.getMinimo(), this.magnitud);

	}

	public void setHoraActual(Hora h0) {
		this.horaActual = h0;
	}

}
