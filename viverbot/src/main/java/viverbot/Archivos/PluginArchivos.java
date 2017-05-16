package viverbot.Archivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.TuplaEstadosValores;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Log;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

public class PluginArchivos extends Observable{
	LectorTxt lector ;
	ValidadorHistorial validadorHistorial ;
	ValidadorEstados validadorEstados ;
	Logger logger;
	public PluginArchivos(){
		logger = Log.getLog(PluginArchivos.class);
	}
	
	public void actuar() throws Exception{
		notificarHistorialesNuevos(levantarArchivos());
	}
	
	public List<HistorialOptimo> levantarArchivos() throws Exception{
		//FALTAN COSAS; VOY A TENER UNOS PARES DE PATHS DONDE BUSCAR
		//Version 0.69
		String directorio = GatewayConfiguracion.getDirectorio(1);
		String file = "";
		File folder = new File(directorio);
	    File[] files = folder.listFiles();
	    List<HistorialOptimo> historiales= new ArrayList<HistorialOptimo>();
	    for (File f : files){
            if (f.isFile()){
                file = f.getName();
                logger.info(file);
                try{
                	HistorialOptimo h = cargarHistorial(directorio+"/"+file);
                	historiales.add(h);
                }
                catch(Exception e){
                	logger.error(e.getMessage());
                }
            }
        }
	    return historiales;
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
		throw new Exception();
	}
	
	protected void notificarHistorialesNuevos(List<HistorialOptimo> historiales) {
		setChanged();
		notifyObservers(historiales);
	}
	
	public boolean cargarEstados(String path) throws Exception{
		lector = new LectorEstados();
		validadorEstados = new ValidadorEstados();
		List<String[]> lectura = ((LectorEstados) lector).leerArchivo(path);
		boolean esValidoEstados = validadorEstados.validarEstados(lectura);
		if(esValidoEstados){
			MediatorParser mediator = new MediatorParser();
			TuplaEstadosValores tupla = mediator.parsearEstadosValores(lectura);
			Integer codigoEspecie = mediator.parsearCodigoEspecie(lectura);
			BuscadorEstadoAltura buscador = new BuscadorEstadoAltura();
			MapperEstadoAltura mapper = new MapperEstadoAltura();
			mapper.relacionar(buscador, tupla, codigoEspecie);
			return false;
		}
		return true;
	}
}
