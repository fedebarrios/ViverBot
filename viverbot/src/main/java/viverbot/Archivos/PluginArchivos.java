package viverbot.Archivos;

import java.util.List;

import viverbot.Model.HistorialOptimo;

public class PluginArchivos {
	LectorHistorial lector ;
	ValidadorHistorial validadorHistorial ;
	
	public PluginArchivos(LectorHistorial lector , ValidadorHistorial validador){
		this.lector = lector;
		this.validadorHistorial = validador;
	}
	
	public HistorialOptimo cargarHistorial(String path){
		lector = new LectorHistorial();
		validadorHistorial = new ValidadorHistorial();
		List<String> lectura = lector.leerArchivo(path);
		boolean esValidoHistorial = validadorHistorial.validarHistorial(lectura);
		boolean esValidoEspecie = validadorHistorial.validarInfoEspecie(lectura);
		if(esValidoHistorial && esValidoEspecie){
			MediatorParser mediator = new MediatorParser();
			HistorialOptimo historial = mediator.parsearHistorialEspecie(lectura);
			if(!CalculadorHistorial.calcularDiferencia(historial)){
				System.out.println("Por favor ingrese un historial mas consistente");
			}
			else{
				return historial;
			}
		}
		else{
			System.out.println("No existe informacion acerca de la especie");
		}
		return null;
	}
}
