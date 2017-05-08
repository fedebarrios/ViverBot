package viverbot.Modelo.Medicion;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.PlanificadorAltura;
import viverbot.Controlador.Verificacion.StrategyAnalisisAltura;
import viverbot.Controlador.Verificacion.StrategyMetroDown;
import viverbot.Controlador.Verificacion.StrategySeguimientoNull;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Modelo.Magnitudes.Altura;
import viverbot.Modelo.Magnitudes.EmptyAltura;

public class AnalizadorAltura {
	private PlanificadorAltura planificador;
	private GuardadorAltura guardador;
	
	public AnalizadorAltura(PlanificadorAltura planificador, GuardadorAltura guardador) {
		this.planificador = planificador;
		this.guardador = guardador;
	}

	public EstadoAltura analizar(Altura alturaActual, SeguimientoAltura seguimiento, int diaActual) {
		Altura alturaEsperada = seguimiento.getHistorialOptimo().buscarTupla(diaActual).getAltura();
		IAnalisisAltura estrategia = getStrategy(alturaActual, alturaEsperada) ;
		EstadoAltura estadoActual = estrategia.analizar(alturaActual, alturaEsperada, seguimiento.getPlanta());
		//guardador.guardar(estrategia, alturaActual, diaActual, seguimiento.getHistorialVerdadero());
		//planificador.actuar(estadoActual);	
		return estadoActual;
	}
	
	public IAnalisisAltura getStrategy(Altura alturaActual, Altura alturaEsperada) {
		if (alturaEsperada instanceof EmptyAltura){
			return new StrategySeguimientoNull();
		}else if (alturaActual.getValor() < 0){
			return new StrategyMetroDown();
		}
		else{
			return new StrategyAnalisisAltura();
		}
	}	
}
