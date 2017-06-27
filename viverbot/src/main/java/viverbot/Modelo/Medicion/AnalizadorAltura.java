package viverbot.Modelo.Medicion;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.Comparador;
import viverbot.Controlador.Verificacion.StrategyMetroDown;
import viverbot.Controlador.Verificacion.StrategySeguimientoNull;
import viverbot.DTO.Planta;
import viverbot.Interfaces.AnalisisAltura;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Medicion;

public class AnalizadorAltura {
	private Comparador comparador;

	public AnalizadorAltura() {
		this.comparador = new Comparador();
	}

	public EstadoAltura analizar(Medicion alturaActual, Medicion alturaIdeal, Planta p) {
		EstadoAltura estadoActual = comparador.comparar(alturaActual, alturaIdeal, p);
		return estadoActual;
	}
}