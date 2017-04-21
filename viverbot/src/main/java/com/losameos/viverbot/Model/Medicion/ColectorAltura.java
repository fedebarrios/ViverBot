package com.losameos.viverbot.Model.Medicion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;

public class ColectorAltura extends Observable{
	private InstrumentoMediator mediator;
	private Timer timer;
	private ArrayList<Magnitud> alturasActuales;
	private TimerTask task;
	private Fecha fechaActual;
	private long milisegundosEnUnDia = 3600000*24;

	private final static Magnitudes m = Magnitudes.ALTURA;

	public ColectorAltura() {
		this.mediator = new InstrumentoMediator(m);
		this.timer = new Timer();
		this.alturasActuales = null;
		
	}

	protected ArrayList<Magnitud> medir() {
		return this.mediator.tomarAlturas();

	}

	@SuppressWarnings("deprecation")
	public void colectar() {

		task = new TimerTask() {

			@Override
			public void run() {
				alturasActuales = medir();
				notificar();

			}

		};
		//La tarea se ejecutara una vez por dia
		fechaActual = Fecha.obtenerFechaActual();
		timer.schedule(task, new Date(fechaActual.getAnio(),fechaActual.getMes(), fechaActual.getDia()) , this.milisegundosEnUnDia );

	}

	protected void notificar() {
		setChanged();
		notifyObservers(alturasActuales);
	}

	public InstrumentoMediator getMediator() {
		return mediator;
	}

	public ArrayList<Magnitud> getValorActual() {
		return alturasActuales;
	}

	public void detenerColeccion() {
		this.timer.cancel();
	}

	public Timer getTimer() {
		return timer;
	}
}
