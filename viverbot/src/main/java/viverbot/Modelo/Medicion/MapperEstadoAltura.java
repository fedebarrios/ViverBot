package viverbot.Modelo.Medicion;

import viverbot.Controlador.Verificacion.SelectorEstadosPorValor;
import viverbot.Model.BuscadorEstadoAltura;

public class MapperEstadoAltura  {
	
	public MapperEstadoAltura(){

	}
	
	public void relacionar(BuscadorEstadoAltura buscador, SelectorEstadosPorValor tuplas, String nombreEspecie){
		buscador.agregarEntrada(tuplas, nombreEspecie);
	}
}
