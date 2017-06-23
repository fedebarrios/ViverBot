package viverbot.Archivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.SelectorEstadosPorValor;
import viverbot.Controlador.Verificacion.Verificador;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Log;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

public class CargadorArchivos extends Observable{
	private Logger logger;
	private LectorArchivo lector;
	private ParserDataArchivos mediator;
	
	public CargadorArchivos(){
		logger = Log.getLog(CargadorArchivos.class);
		lector = new LectorArchivo();
		mediator = new ParserDataArchivos();
	}
	
	public void actuar() throws Exception{
		notificarHistorialesNuevos(seleccionarMejorDirectorio());
	}
	
	protected void notificarHistorialesNuevos(List<HistorialOptimo> historiales) {
		setChanged();
		notifyObservers(historiales);
	}
	
	public List<HistorialOptimo> seleccionarMejorDirectorio() {
		List<String> directorios = GatewayConfiguracion.getDirectorios();
		for(String path :directorios) {
			List<HistorialOptimo> historiales = levantarArchivos (path);
			if(historiales.size()>0) return historiales;
		}
		//throw new Exception("No hay historiales consistentes para cargar");
		return null;
	}
	
	public List<HistorialOptimo> levantarArchivos (String directorio){
		String file = "";
		File folder = new File(directorio);
	    File[] files = folder.listFiles();
	    List<HistorialOptimo> historiales= new ArrayList<HistorialOptimo>();
	    for (File f : files){
            if (f.isFile()){
                file = f.getName();
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
	
	public HistorialOptimo cargarHistorial(String path) throws Exception {
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
	
	public boolean cargarEstados(String path) throws Exception{
		LectorArchivo lector = new LectorArchivo();
		String lectura = lector.leerArchivo(path);
		ParserDataArchivos parser = new ParserDataArchivos();
		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
		ArrayList<Double> valores = parser.parsearValores(lectura);
		Integer codigoEspecie = parser.parsearCodigoEspecie(lectura);
		SelectorEstadosPorValor tupla = new SelectorEstadosPorValor(estados, valores);
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
		mapper.relacionar(buscador, tupla, codigoEspecie);
		return true;
	}
	
	public boolean cargarEstadosBatch(String directorio) throws Exception{
		LectorArchivo lector = new LectorArchivo();
		String file = "";
		File folder = new File(directorio);
	    File[] files = folder.listFiles();
		ParserDataArchivos parser = new ParserDataArchivos();
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
	    for (File f : files){
            if (f.isFile()){
                file = f.getName();
                try{
            		String lectura = lector.leerArchivo(directorio+"/"+file);
            		ArrayList<EstadoAltura> estados = parser.parsearEstados(lectura);
            		ArrayList<Double> valores = parser.parsearValores(lectura);
            		Integer codigoEspecie = parser.parsearCodigoEspecie(lectura);
            		SelectorEstadosPorValor tupla = new SelectorEstadosPorValor(estados, valores);
            		mapper.relacionar(buscador, tupla, codigoEspecie);
                }
                catch(Exception e){
                	logger.error(e.getMessage());
                }
            }
        }
		return true;
	}
}
