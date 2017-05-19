package viverbot.Modelo.Simulacion;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import viverbot.Model.Hora;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class Simulador {

	private Map<Horario, RangoNumerico> rangos;
	private Magnitudes magnitud;
	private Hora horaActual;
	private Medicion valorActual;
	private long frecuencia;

	public Simulador(Map<Horario, RangoNumerico> r, Magnitudes m) {
		this.rangos = r;
		magnitud = m;
		this.horaActual = Hora.obtenerHoraActual();
		this.actualizarValorActual(this.horaActual);
		this.frecuencia = 300000;
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

	public Medicion getMedicion() {
		return this.valorActual;
	}

	public Hora getHora() {
		// TODO Auto-generated method stub
		return this.horaActual;
	}

	public void setFrecuencia(long i) {
		this.frecuencia = i;
	}

}
