package viverbot.Model;

import viverbot.Controlador.Verificacion.Comparador;
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
	
	public void guardar(Medicion altura, int diaActual, HistorialAltura historial) {
		historial.agregarRegistro(diaActual, altura);
	}
}
