package viverbot.Interfaces;

import viverbot.Controller.Verificacion.EstadoAltura;
import viverbot.DTO.PlantaDTO;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.Magnitudes.Altura;
import viverbot.Model.Magnitudes.Magnitud;

public interface IAnalisisAltura {
	
	public EstadoAltura analizar(Altura a, Altura b, PlantaDTO planta);
}
