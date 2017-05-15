package viverbot.Archivos;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Log;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

public class PluginArchivos {
	LectorTxt lector ;
	ValidadorHistorial validadorHistorial ;
	ValidadorEstados validadorEstados ;
	Logger logger;
	public PluginArchivos(){
		logger = Log.getLog(PluginArchivos.class);
	}
	
	public List<HistorialOptimo> levantarArchivos() throws Exception{
		//FALTAN COSAS; VOY A TENER UNOS PARES DE PATHS DONDE BUSCAR
		//Version 0.69
		String directorio = "src/test/java/viverbot";
		String file;
		File folder = new File(directorio);
	    File[] files = folder.listFiles(); 
	    for (File f : files){
            if (f.isFile()){
                file = f.getName();
                logger.info(file);
                HistorialOptimo h = cargarHistorial(directorio+"/"+file);
            }
        }
	    return null;
	}
	
	public HistorialOptimo cargarHistorial(String path) throws Exception{
		lector = new LectorHistorial();
		validadorHistorial = new ValidadorHistorial();
		List<String> lectura = ((LectorHistorial) lector).leerArchivo(path);
		boolean esValidoHistorial = validadorHistorial.validarHistorial(lectura);
		if(esValidoHistorial){
			MediatorParser mediator = new MediatorParser();
			HistorialOptimo historial = mediator.parsearHistorialEspecie(lectura);
			if(!CalculadorHistorial.calcularDiferencia(historial)){
				logger.info("Por favor ingrese un historial mas consistente");
			}
			else{
				return historial;
			}
		}
		else{
			logger.info("No existe informacion acerca de la especie");
		}
		return null;
	}
	
	public boolean cargarEstados(String path) throws Exception{
		lector = new LectorEstados();
		validadorEstados = new ValidadorEstados();
		List<String[]> lectura = ((LectorEstados) lector).leerArchivo(path);
		boolean esValidoEstados = validadorEstados.validarEstados(lectura);
		if(esValidoEstados){
			MediatorParser mediator = new MediatorParser();
			List<EstadoAltura> estados = mediator.parsearEstados(lectura);
			BuscadorEstadoAltura buscador = new BuscadorEstadoAltura();
			MapperEstadoAltura mapper = new MapperEstadoAltura();
			mapper.relacionar(buscador, estados);
			return false;
		}
		return true;
	}
}
