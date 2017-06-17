package viverbot.Interfaces;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.Planta;
import viverbot.Modelo.Magnitudes.Medicion;

public interface AnalisisAltura {
	
	public EstadoAltura analizar(Medicion a, Medicion b, Planta planta);
}
