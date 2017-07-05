package viverbot.Archivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.Verificador;
import viverbot.Model.HistorialIdeal;
import viverbot.Model.Log;

public class CargadorArchivos extends Observable{
	private Logger logger;
	private ParserDataArchivos mediator;
	
	public CargadorArchivos(){
		logger = Log.getLog(CargadorArchivos.class);
		mediator = new ParserDataArchivos();
	}
	
	public void actuar() throws Exception{
		notificarHistorialesNuevos(seleccionarMejorDirectorio());
	}
	
	protected void notificarHistorialesNuevos(List<HistorialIdeal> historiales) {
		setChanged();
		notifyObservers(historiales);
	}
	
	public List<HistorialIdeal> seleccionarMejorDirectorio() {
		List<String> directorios = GatewayConfiguracion.getDirectorios();
		for(String path :directorios) {
			List<HistorialIdeal> historiales = levantarArchivos (path);
			if(historiales.size()>0) return historiales;
		}
		//throw new Exception("No hay historiales consistentes para cargar");
		return null;
	}
	
	public List<HistorialIdeal> levantarArchivos (String directorio){
		String file = "";
		File folder = new File(directorio);
	    File[] files = folder.listFiles();
	    List<HistorialIdeal> historiales= new ArrayList<HistorialIdeal>();
	    for (File f : files){
            if (f.isFile()){
                file = f.getName();
                try{
                	HistorialIdeal h = cargarHistorial(directorio+"/"+file);
                	historiales.add(h);
                }
                catch(Exception e){
                	logger.error(e.getMessage());
                }
            }
        }
	    return historiales;
	}
	
	public HistorialIdeal cargarHistorial(String path) throws Exception {
		if (!Verificador.validarExistencia(path)) {
			throw new Exception("No existe archivo.");
		} else if (!Verificador.validarExtension(path, ".txt")) {
			throw new Exception("La extension del archivo no es .txt.");
		}
		try{
			return mediator.parsearHistorialEspecie(path);
		} catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
}
