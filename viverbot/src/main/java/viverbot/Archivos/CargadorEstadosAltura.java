package viverbot.Archivos;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.EstadosDeAlturaDisponibles;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Model.Log;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

public class CargadorEstadosAltura {
	private Logger logger;
	
	public CargadorEstadosAltura(){
		logger = Log.getLog(CargadorArchivos.class);
	}
	
	public boolean cargarEstados(String path) throws Exception{
		LectorArchivo lector = new LectorArchivo();
		String lectura = lector.leerArchivo(path);
		ArrayList<EstadoAltura> estados = ParserEstadosAltura.parsearEstados(lectura);
		ArrayList<Double> valores = ParserValoresEstadosAltura.parsearValores(lectura);
		String nombreEspecie = ParserNombreEspecie.parsearNombreEspecie(lectura);
		EstadosDeAlturaDisponibles tupla = new EstadosDeAlturaDisponibles(estados, valores);
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
		mapper.relacionar(buscador, tupla, nombreEspecie);
		return true;
	}
	
	public boolean cargarEstadosBatch(String directorio) throws Exception{
		LectorArchivo lector = new LectorArchivo();
		String file = "";
		File folder = new File(directorio);
	    File[] files = folder.listFiles();
		BuscadorEstadoAltura buscador = BuscadorEstadoAltura.getInstance();
		MapperEstadoAltura mapper = new MapperEstadoAltura();
	    for (File f : files){
            if (f.isFile()){
                file = f.getName();
                try{
            		String lectura = lector.leerArchivo(directorio+"/"+file);
            		ArrayList<EstadoAltura> estados = ParserEstadosAltura.parsearEstados(lectura);
            		ArrayList<Double> valores = ParserValoresEstadosAltura.parsearValores(lectura);
            		String nombreEspecie = ParserNombreEspecie.parsearNombreEspecie(lectura);
            		EstadosDeAlturaDisponibles tupla = new EstadosDeAlturaDisponibles(estados, valores);
            		mapper.relacionar(buscador, tupla, nombreEspecie);
                }
                catch(Exception e){
                	logger.error(e.getMessage());
                }
            }
        }
		return true;
	}
}
