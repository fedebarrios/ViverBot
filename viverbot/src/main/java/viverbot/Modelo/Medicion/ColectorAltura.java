package viverbot.Modelo.Medicion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import viverbot.DTO.Planta;
import viverbot.Model.Plantas;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class ColectorAltura extends Observable{
	private InstrumentoMediator mediator;
	private Timer timer;
	private List<Medicion> alturasActuales;
	private TimerTask task;
	private long milisegundosEnUnDia = 3600000*24;


	// si te fijas bien ahora este colector sirve para cualquier cosa n.nm no necesariamente altura :v
	public ColectorAltura(InstrumentoMediator m) {
		this.mediator = m;
		this.timer = new Timer();
		this.alturasActuales = null;	
	}

	protected List<Medicion> medir(List<Planta> plantas) {
		List<Medicion> alturasActuales = new ArrayList<Medicion>();
		for (Planta p : plantas){
			alturasActuales.add(this.mediator.tomarMedicion());
		}
		return alturasActuales;

	}

	public void colectar() {

		task = new TimerTask() {
			
			List<Planta> plantas = new Plantas().obtenerPlantas();
			@Override
			public void run() {
				alturasActuales = medir(plantas);
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

	public List<Medicion> getValorActual() {
		return alturasActuales;
	}

	public void detenerColeccion() {
		this.timer.cancel();
	}

	public Timer getTimer() {
		return timer;
	}
}
