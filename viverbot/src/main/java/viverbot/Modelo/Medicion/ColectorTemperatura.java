package viverbot.Modelo.Medicion;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class ColectorTemperatura extends Observable {

	private InstrumentoMediator mediator;
	private long frecuencia;
	private long delay;
	private Timer timer;
	private Medicion valorActual;

	public ColectorTemperatura(long frecuencia, long delay, InstrumentoMediator mediator) {
		this.mediator = mediator;
		this.frecuencia = frecuencia;
		this.delay = delay;
		this.timer = new Timer();
		this.valorActual = null;

	}

	public Medicion medir() {
		return this.mediator.tomarMedicion();

	}

	public void colectar() {
		Timer timer =  new Timer();
		TimerTask t = new TimerTask() {

			@Override
			public void run() {
				valorActual = medir();
				notificar();

			}

		};

		timer.schedule(t, delay, frecuencia);

	}

	protected void notificar() {
		setChanged();
		notifyObservers(valorActual);
	}

	public InstrumentoMediator getMediator() {
		return mediator;
	}

	public Medicion getValorActual() {
		return valorActual;
	}

	public void detenerColeccion() {
		this.timer.cancel();
	}

	public long getDelay() {
		return delay;
	}

	public long getFrecuencia() {
		return frecuencia;
	}

	public Timer getTimer() {
		return timer;
	}

}
