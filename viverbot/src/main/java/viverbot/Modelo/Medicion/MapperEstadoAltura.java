package viverbot.Modelo.Medicion;

import viverbot.Controlador.Verificacion.TuplaEstadosValores;
import viverbot.Model.BuscadorEstadoAltura;

public class MapperEstadoAltura  {
	
	public MapperEstadoAltura(){

	}
	
	public void relacionar(BuscadorEstadoAltura buscador, TuplaEstadosValores tuplas, Integer codigoEspecie){
		buscador.agregarEntrada(tuplas, codigoEspecie);
	}
}
