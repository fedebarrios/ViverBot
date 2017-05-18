package viverbot.Modelo.Monitoreo;

import java.util.Observable;
import java.util.Observer;

import viverbot.Controlador.VistaPrincipalController;
import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class MonitorEstado extends Observable implements Observer {
	private Medicion temperaturaActual;
	private AnalizadorTemperatura analizador;

	public MonitorEstado() {
		this.temperaturaActual = new Medicion(0.0, Magnitudes.TEMPERATURA);
		this.analizador = new AnalizadorTemperatura();
	}

	public Medicion getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(Medicion t) {
		this.temperaturaActual = new Medicion(t.getValor(), t.getTipo());
	}

	@Override
	public void update(Observable o, Object arg) {
		monitorear(arg);
	}

	public DiagnosticoAnalisis monitorear(Object arg) {
		if (!this.temperaturaActual.equals(arg)) {
			this.setTemperaturaActual((Medicion) arg);
			DiagnosticoAnalisis d = this.analizador.analizar(this.temperaturaActual,
					EstadoVivero.getInstance().getRangoTemperatura());
			this.setChanged();
			this.notifyObservers(d);
			return d;
		}
		return null;
	}

}
