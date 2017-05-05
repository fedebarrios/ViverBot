package viverbot.Modelo.Medicion;

import viverbot.Controlador.Verificacion.StrategyMagnitudInvalida;
import viverbot.Controlador.Verificacion.StrategyRangoTemperatura;
import viverbot.Interfaces.IAnalisis;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Temperatura;

public class AnalizadorTemperatura {
	private IAnalisis estrategia;
	private Magnitud m;
	private DiagnosticoAnalisis estado;
	private RangoNumerico rango;

	private static RangoNumerico rangoIdeal = new RangoNumerico(10.0, 30.0);

	public AnalizadorTemperatura() {
		this.m = null;
		this.estado = null;
		this.rango = rangoIdeal;
	}

	public DiagnosticoAnalisis analizar(Magnitud temp) {
		this.m = temp;
		IAnalisis estrategia = this.getStrategy(m);
		this.estado = estrategia.analizar(m, this.rango);
		return estado;

	}

	private IAnalisis getStrategy(Magnitud temp) {
		if (temp instanceof Temperatura) {
			return new StrategyRangoTemperatura();
		} else {
			return new StrategyMagnitudInvalida();
		}
	}

	public Magnitud getValorRecibido() {
		return m;
	}

	public DiagnosticoAnalisis getEstado() {
		return this.estado;
	}

	public void setRango(RangoNumerico r) {
		this.rango = r;
	}

}
