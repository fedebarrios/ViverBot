package viverbot.Model.Medicion;

import java.util.List;

import viverbot.DTO.PlantaDTO;
import viverbot.Model.BuscadorHistorial;
import viverbot.Model.Magnitudes.Altura;

public class MapperAltura {
	
	private AnalizadorAltura analizador;
	private List<PlantaDTO> plantas;
	private BuscadorHistorial buscador;
	
	public MapperAltura(AnalizadorAltura analizador, List<PlantaDTO> plantas, BuscadorHistorial buscador){
		this.analizador = analizador;
		this.plantas = plantas;
	}
	
	public void relacionar(List<Altura> alturas){
		int i = 0;
		for(PlantaDTO p : plantas){
			analizador.analizar(alturas.get(i), buscador.buscarSeguimiento(p));
			i++;
		}
	}

}
