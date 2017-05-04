package viverbot.Model.Medicion;

import viverbot.Controller.Verificacion.EstadoAltura;
import viverbot.Controller.Verificacion.PlanificadorAltura;
import viverbot.Controller.Verificacion.StrategyAnalisisAltura;
import viverbot.Controller.Verificacion.StrategyMetroDown;
import viverbot.Controller.Verificacion.StrategySeguimientoNull;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.GuardadorAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.Magnitudes.Altura;
import viverbot.Model.Magnitudes.EmptyAltura;

public class AnalizadorAltura implements AnalizadorMagnitud{
	private PlanificadorAltura planificador;
	private GuardadorAltura guardador;
	
	public AnalizadorAltura(PlanificadorAltura planificador, GuardadorAltura guardador) {
		this.planificador = planificador;
		this.guardador = guardador;
	}

	public void analizar(Altura alturaActual, SeguimientoAltura seguimiento) {
		int diaActual = seguimiento.getUltimoDiaMedicion()+1;
		Altura alturaEsperada = seguimiento.getHistorialOptimo().buscarTupla(diaActual).getAltura();
		IAnalisisAltura estrategia = getStrategy(alturaActual, alturaEsperada) ;
		EstadoAltura estadoActual = estrategia.analizar(alturaActual, alturaEsperada, seguimiento.getPlanta());
		guardador.guardar(estrategia, alturaActual, diaActual, seguimiento.getHistorialVerdadero());
		planificador.actuar(estadoActual);		
	}
	
	private IAnalisisAltura getStrategy(Altura alturaActual, Altura alturaEsperada) {
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
