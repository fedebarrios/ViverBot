package viverbot.Archivos;

import java.util.List;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Model.HistorialOptimo;

public class PluginArchivos {
	LectorTxt lector ;
	ValidadorHistorial validadorHistorial ;
	ValidadorEstados validadorEstados ;
	
	public PluginArchivos(){
		
	}
	
	public HistorialOptimo cargarHistorial(String path){
		lector = new LectorHistorial();
		validadorHistorial = new ValidadorHistorial();
		List<String> lectura = ((LectorHistorial) lector).leerArchivo(path);
		boolean esValidoHistorial = validadorHistorial.validarHistorial(lectura);
		if(esValidoHistorial){
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
	
	public Object cargarEstados(String path){
		lector = new LectorEstados();
		validadorEstados = new ValidadorEstados();
		List<String[]> lectura = ((LectorEstados) lector).leerArchivo(path);
		boolean esValidoEstados = validadorEstados.validarEstados(lectura);
		if(esValidoEstados){
			MediatorParser mediator = new MediatorParser();
			List<EstadoAltura> estados = mediator.parsearEstados(lectura);
			return estados;
		}
		return null;
	}
}
