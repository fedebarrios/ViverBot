package viverbot.Modelo.Medicion;

import java.util.List;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Model.BuscadorEstadoAltura;

public class MapperEstadoAltura  {
	
	public MapperEstadoAltura(){

	}
	
	public void relacionar(BuscadorEstadoAltura buscador, List<EstadoAltura> estados){
		buscador.setEstados(estados);
	}
}
