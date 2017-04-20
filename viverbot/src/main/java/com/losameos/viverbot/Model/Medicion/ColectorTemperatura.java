package com.losameos.viverbot.Model.Medicion;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class ColectorTemperatura extends Observable {

	private InstrumentoMediator mediator;
	private long frecuencia;
	private long delay;
	private Timer timer;
	private Magnitud valorActual;

	private final static Magnitudes m = Magnitudes.TEMPERATURA;

	public ColectorTemperatura(long frecuencia, long delay) {
		mediator = new InstrumentoMediator(m);
		this.frecuencia = frecuencia;
		this.delay = delay;
		this.timer = new Timer();
		this.valorActual = null;
	}

	protected Magnitud medir() {
		Magnitud ret  = this.mediator.tomarMedicion();
		setChanged();
		notifyObservers(valorActual);
		return ret;
		
	}

	public void colectar() {

		TimerTask t = new TimerTask() {

			@Override
			public void run() {
				valorActual = medir();
				
			}
		};
		timer.schedule(t, delay, frecuencia);

	}

	public InstrumentoMediator getMediator() {
		return mediator;
	}

	public Magnitud getValorActual() {
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
