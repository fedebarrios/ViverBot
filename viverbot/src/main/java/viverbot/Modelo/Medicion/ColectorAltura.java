package viverbot.Modelo.Medicion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;

public class ColectorAltura extends Observable{
	private InstrumentoMediator mediator;
	private Timer timer;
	private ArrayList<Magnitud> alturasActuales;
	private TimerTask task;
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

	public void colectar() {

		task = new TimerTask() {

			@Override
			public void run() {
				alturasActuales = medir();
				notificar();

			}

		};
		//La tarea se ejecutara una vez por dia
		timer.schedule(task, new Date() , this.milisegundosEnUnDia );
		//timer.schedule(task, 0, 3000);

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
