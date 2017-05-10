package viverbot.Modelo.Medicion;

import java.util.Observable;
import java.util.Observer;

import viverbot.Controlador.Verificacion.StrategyMagnitudInvalida;
import viverbot.Controlador.Verificacion.StrategyRangoTemperatura;
import viverbot.Interfaces.IAnalisis;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class AnalizadorTemperatura implements Observer {
	private IAnalisis estrategia;
	private Medicion m;
	private DiagnosticoAnalisis estado;
	private RangoNumerico rango;

	private static RangoNumerico rangoIdeal = new RangoNumerico(10.0, 30.0);

	public AnalizadorTemperatura() {
		this.m = null;
		this.estado = null;
		this.rango = rangoIdeal;
	}

	public DiagnosticoAnalisis analizar(Medicion medicion) {
		this.m = medicion;
		IAnalisis estrategia = this.getStrategy(m);
		this.estado = estrategia.analizar(m, this.rango);
		return estado;

	}

	private IAnalisis getStrategy(Medicion m) {
		if (m.getTipo().equals(Magnitudes.TEMPERATURA)) {
			return new StrategyRangoTemperatura();
		} else {
			return new StrategyMagnitudInvalida();
		}
	}

	public Medicion getValorRecibido() {
		return m;
	}

	public DiagnosticoAnalisis getEstado() {
		return this.estado;
	}

	public void setRango(RangoNumerico r) {
		this.rango = r;
	}

	@Override
	public void update(Observable o, Object medicion) {
		this.analizar((Medicion) medicion);
		
	}

}