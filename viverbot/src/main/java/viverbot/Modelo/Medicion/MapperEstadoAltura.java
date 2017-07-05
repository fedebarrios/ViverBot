package viverbot.Modelo.Medicion;

import viverbot.Controlador.Verificacion.EstadosDeAlturaDisponibles;
import viverbot.Model.BuscadorEstadoAltura;

public class MapperEstadoAltura  {
	
	public MapperEstadoAltura(){

	}
	
	public void relacionar(BuscadorEstadoAltura buscador, EstadosDeAlturaDisponibles tuplas, String nombreEspecie){
		buscador.agregarEntrada(tuplas, nombreEspecie);
	}
}
