package com.losameos.viverbot.Controller.Verificacion;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Medicion.InstrumentoMediator;

public class ColectorTemperatura extends Observable {

	protected InstrumentoMediator mediator;
	private long frecuencia;
	private long delay;
	private final static Magnitudes m = Magnitudes.TEMPERATURA;

	public ColectorTemperatura(long frecuencia, long delay) {
		mediator = new InstrumentoMediator(m);
		this.frecuencia = frecuencia;
		this.delay = delay;
	}

	private Magnitud medir() {
		return this.mediator.tomarMedicion();
	}

	public void colectar() {

		TimerTask t = new TimerTask() {
			@Override
			public void run() {
				Magnitud valorActual = medir();
				setChanged();
				notifyObservers(valorActual);
			}
		};

		Timer timer = new Timer();
		timer.schedule(t, delay, frecuencia);
	}

}
