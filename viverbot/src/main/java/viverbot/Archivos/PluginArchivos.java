package viverbot.Archivos;

import java.util.List;

import viverbot.Model.HistorialOptimo;

public class PluginArchivos {
	
	public HistorialOptimo cargarHistorial(String path){
		LectorHistorial lector = new LectorHistorial();
		ValidadorHistorial validadorHistorial = new ValidadorHistorial();
		List<String> lectura = lector.leerArchivo(path);
		boolean esValido = validadorHistorial.validarHistorial(lectura);
		if(esValido){
			MediatorParser mediator = new MediatorParser();
			HistorialOptimo historial = mediator.parsearHistorialEspecie(lectura);
			if(!CalculadorHistorial.calcularDiferencia(historial)){
				System.out.println("Por favor ingrese un historial mas consistente");
			}
			else{
				return historial;
			}
		}
		return null;
	}
}
