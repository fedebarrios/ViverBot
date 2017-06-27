package viverbot.Modelo.Monitoreo;

import java.util.Observable;
import java.util.Observer;

import viverbot.Controlador.VistaPrincipalController;
import viverbot.Model.EstadoVivero;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;
import viverbot.Modelo.Medicion.MedicionVacioException;

public class MonitorEstado extends Observable implements Observer {
	private Medicion ultimaMedicion;

	public MonitorEstado() {
		this.ultimaMedicion = new Medicion(0.0, Magnitud.TEMPERATURA);
	}
	public Medicion getUltimaMedicion() {
		return ultimaMedicion;
	}

	public void setTemperaturaActual(Medicion t) {
		this.ultimaMedicion = new Medicion(t.getValor(), t.getTipo());
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			monitorear(arg);
		} catch (MedicionVacioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DiagnosticoAnalisis monitorear(Object arg) throws MedicionVacioException {
		if (!this.ultimaMedicion.equals(arg)) {
			this.setTemperaturaActual((Medicion) arg);
			DiagnosticoAnalisis d = AnalizadorTemperatura.analizar(this.ultimaMedicion,
					EstadoVivero.getInstance().getRangoTemperatura());
			this.setChanged();
			this.notifyObservers(d);
			return d;
		}
		return null;
	}

}
