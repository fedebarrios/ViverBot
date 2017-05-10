package viverbot.Modelo.Medicion;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.Controlador.Verificacion.StrategyAnalisisAltura;
import viverbot.Controlador.Verificacion.StrategyMetroDown;
import viverbot.Controlador.Verificacion.StrategySeguimientoNull;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Medicion;

public class AnalizadorAltura {
	private GuardadorAltura guardador;
	
	public AnalizadorAltura(GuardadorAltura guardador) {
		this.guardador = guardador;
	}

	public EstadoAltura analizar(Medicion alturaActual, SeguimientoAltura seguimiento, int diaActual) {
		Medicion alturaEsperada = seguimiento.getHistorialOptimo().buscarTupla(diaActual).getAltura();
		IAnalisisAltura estrategia = getStrategy(alturaActual, alturaEsperada) ;
		EstadoAltura estadoActual = estrategia.analizar(alturaActual, alturaEsperada, seguimiento.getPlanta());
		//guardador.guardar(estrategia, alturaActual, diaActual, seguimiento.getHistorialVerdadero());
		//planificador.actuar(estadoActual);	
		return estadoActual;
	}
	
	public IAnalisisAltura getStrategy(Medicion alturaActual, Medicion alturaEsperada) {
		if (alturaEsperada instanceof EmptyMedicion){
			return new StrategySeguimientoNull();
		}else if (alturaActual.getValor() < 0){
			return new StrategyMetroDown();
		}
		else{
			return new StrategyAnalisisAltura();
		}
	}	
}
