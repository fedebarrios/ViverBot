package viverbot.Model;

import viverbot.Controller.Verificacion.StrategyAnalisisAltura;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.Magnitudes.Altura;

public class GuardadorAltura {
	
	private static GuardadorAltura guardador;
	
	private GuardadorAltura(){
	}
	
	public static GuardadorAltura getInstance(){
		if(guardador == null ){
			guardador = new GuardadorAltura();
		}
		return guardador;
	}
	
	public void guardar(IAnalisisAltura estrategia, Altura altura, int diaActual , HistorialAltura historial){
		if( estrategia instanceof StrategyAnalisisAltura){
			historial.agregarTupla(new TuplaAltura(altura, diaActual));
		}
	}
}
