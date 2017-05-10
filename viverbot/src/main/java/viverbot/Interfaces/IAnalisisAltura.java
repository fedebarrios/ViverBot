package viverbot.Interfaces;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.PlantaDTO;
import viverbot.Modelo.Magnitudes.Medicion;

public interface IAnalisisAltura {
	
	public EstadoAltura analizar(Medicion a, Medicion b, PlantaDTO planta);
}
