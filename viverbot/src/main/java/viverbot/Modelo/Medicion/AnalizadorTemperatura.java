package viverbot.Modelo.Medicion;

import java.util.Observable;
import java.util.Observer;

import viverbot.Controlador.Verificacion.StrategyMagnitudInvalida;
import viverbot.Controlador.Verificacion.StrategyRangoTemperatura;
import viverbot.Interfaces.Analisis;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;

public class AnalizadorTemperatura {
	private Analisis estrategia;
	private Medicion m;
	private DiagnosticoAnalisis estado;


	public AnalizadorTemperatura() {
		this.m = null;
		this.estado = null;
	}

	public DiagnosticoAnalisis analizar(Medicion medicion, RangoNumerico r) {
		this.m = medicion;
		Analisis estrategia = this.getStrategy(m);
		this.estado = estrategia.analizar(m, r);
		return estado;

	}

	private Analisis getStrategy(Medicion m) {
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

	

}
