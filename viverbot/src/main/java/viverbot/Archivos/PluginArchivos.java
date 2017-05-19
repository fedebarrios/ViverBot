package viverbot.Archivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Controlador.Verificacion.SelectorEstadosPorValor;
import viverbot.Model.BuscadorEstadoAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.Log;
import viverbot.Modelo.Medicion.MapperEstadoAltura;

public class PluginArchivos extends Observable{
	private Logger logger;
	private LectorTxt lector;
	private ParserDataArchivos mediator;
	
	public PluginArchivos(){
		logger = Log.getLog(PluginArchivos.class);
		lector = new LectorTxt();
		mediator = new ParserDataArchivos();
	}
	
	public void actuar() throws Exception{
		notificarHistorialesNuevos(seleccionarMejorDirectorio());
	}
	
	protected void notificarHistorialesNuevos(List<HistorialOptimo> historiales) {
		setChanged();
		notifyObservers(historiales);
	}
	
	public List<HistorialOptimo> seleccionarMejorDirectorio(){
		List<HistorialOptimo> historiales1 = levantarArchivos (GatewayConfiguracion.getDirectorio(1));
		List<HistorialOptimo> historiales2 = levantarArchivos (GatewayConfiguracion.getDirectorio(2));
		List<HistorialOptimo> historiales3 = levantarArchivos (GatewayConfiguracion.getDirectorio(3));
		if(historiales1.size() > historiales2.size() && historiales1.size() > historiales3.size()){
			return historiales1;
		} else if(historiales2.size() > historiales1.size() && historiales2.size() > historiales3.size()){
			return historiales2;
		} else {
			return historiales3;
		}
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
		String lectura = lector.leerTxt(path);
		try{
			HistorialOptimo historial = mediator.parsearHistorialEspecie(lectura);
			if(!CalculadorHistorial.calcularDiferencia(historial)){
				throw new Exception("Por favor ingrese un historial mas consistente");
			}
			else{
				return historial;
			}
		} catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean cargarEstados(String path) throws Exception{
		LectorTxt lector = new LectorTxt();
		String lectura = lector.leerTxt(path);
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
}
