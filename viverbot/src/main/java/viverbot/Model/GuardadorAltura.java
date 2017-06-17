package viverbot.Model;

import viverbot.Controlador.Verificacion.StrategyAnalisisAltura;
import viverbot.Interfaces.AnalisisAltura;
import viverbot.Modelo.Magnitudes.Medicion;

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
	
	public void guardar(AnalisisAltura estrategia, Medicion altura, int diaActual , HistorialAltura historial){
		if( estrategia instanceof StrategyAnalisisAltura){
			historial.agregarTupla(new TuplaAltura(altura, diaActual));
		}
	}
}
