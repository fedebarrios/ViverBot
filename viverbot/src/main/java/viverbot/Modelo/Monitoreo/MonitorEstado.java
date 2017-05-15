package viverbot.Modelo.Monitoreo;

import java.util.Observable;
import java.util.Observer;

import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AnalizadorTemperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class MonitorEstado implements Observer {
	private Medicion temperaturaActual;
	private AnalizadorTemperatura analizador;

	MonitorEstado() {
		this.temperaturaActual = new Medicion(0.0, Magnitudes.TEMPERATURA);
	}

	public Medicion getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(Medicion t) {
		this.temperaturaActual = new Medicion(t.getValor(), t.getTipo());
	}

	@Override
	public void update(Observable o, Object arg) {
		if(!this.temperaturaActual.equals(arg)){
			this.setTemperaturaActual((Medicion) arg);
			DiagnosticoAnalisis d = this.analizador.analizar(this.temperaturaActual);
			if(!d.getOptima()){
				System.out.println("La temperatura es fuera del rango ideal enviad ayuda :'v");
			}

		}
	}

}
