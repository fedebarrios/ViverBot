package viverbot.Interfaces;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.DTO.PlantaDTO;
import viverbot.Model.SeguimientoAltura;
import viverbot.Modelo.Magnitudes.Altura;
import viverbot.Modelo.Magnitudes.Magnitud;

public interface IAnalisisAltura {
	
	public EstadoAltura analizar(Altura a, Altura b, PlantaDTO planta);
}
