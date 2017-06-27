package viverbot.Modelo.Simulacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Sensores.Medir;

public class Simulador implements Medir{

	private Map<Horario, RangoNumerico> rangos;
	private Magnitudes magnitud;
	private Hora horaActual;
	private Medicion valorActual;
	private long frecuencia;

	public Simulador(Map<Horario, RangoNumerico> r, long f, Magnitudes m) {
		this.rangos = r;
		this.horaActual = Hora.obtenerHoraActual();
		this.actualizarValorActual(this.horaActual);
		this.frecuencia = f;
		this.magnitud = m;
		this.simular();
	}

	public void simular() {
		Timer timer = new Timer();
		TimerTask t = new TimerTask() {

			@Override
			public void run() {
				actualizarValorActual(Hora.obtenerHoraActual());

			}

		};
		timer.schedule(t, 0, this.frecuencia);
	}

	public void actualizarValorActual(Hora h0) {
		this.horaActual = h0;
		this.valorActual = this.crearMedicion(h0);
	}

	private Medicion crearMedicion(Hora h) {
		RangoNumerico r = getRango(h);
		return new Medicion(Math.random() * (r.getMaximo() - r.getMinimo()) + r.getMinimo(), this.magnitud);

	}

	public RangoNumerico getRango(Hora h) {
		return this.rangos.get(Horario.getHorario(h));
	}

	public void setHoraActual(Hora h0) {
		actualizarValorActual(h0);
	}

	public Hora getHora() {
		return this.horaActual;
	}


	@Override
	public Medicion getMedicion() {
		return this.valorActual;
	}
	
	public static Map<Horario, RangoNumerico> inicializarRangos(String rangos) {
		Map<Horario, RangoNumerico> r = new HashMap<Horario, RangoNumerico>();
		ArrayList<RangoNumerico> rango = RangoNumerico.parseRangoNumerico(rangos);
		Horario[] horarios = Horario.values();
		for (int i = 0; i < horarios.length; i++) {
			r.put(horarios[i], rango.get(i));
		}

		return r;
	}
}
