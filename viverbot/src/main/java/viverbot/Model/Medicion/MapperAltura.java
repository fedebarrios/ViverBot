package viverbot.Model.Medicion;

import java.util.List;

import viverbot.DTO.PlantaDTO;
import viverbot.Model.ControlSeguimientos;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.Magnitudes.Altura;

public class MapperAltura {
	
	private AnalizadorAltura analizador;
	private List<PlantaDTO> plantas;
	private ControlSeguimientos buscador;
	
	public MapperAltura(AnalizadorAltura analizador, List<PlantaDTO> plantas, ControlSeguimientos buscador){
		this.analizador = analizador;
		this.plantas = plantas;
		this.buscador = buscador;
	}
	
	public void relacionar(List<Altura> alturas){
		int i = 0;
		for(PlantaDTO p : plantas){
			SeguimientoAltura seguimiento = buscador.getSeguimiento(p);
			if(seguimiento == null) System.out.println("es nulo");
			analizador.analizar(alturas.get(i), seguimiento);
			i++;
		}
	}

}
