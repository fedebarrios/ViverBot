package viverbot.Archivos;

import java.util.List;

import viverbot.Model.HistorialOptimo;

public class PluginArchivos {
	
	public void cargarHistorial(){
		LectorHistorial lector = new LectorHistorial();
		ValidadorHistorial validadorHistorial = new ValidadorHistorial();
		List<String> lectura = lector.leerArchivo("path");
		boolean esValido = validadorHistorial.validarHistorial(lectura);
		if(esValido){
			MediatorParser mediator = new MediatorParser();
			HistorialOptimo historial = mediator.parsearHistorialEspecie(lectura);
			
		}
	}
}
