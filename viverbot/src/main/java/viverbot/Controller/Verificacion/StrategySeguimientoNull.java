package viverbot.Controller.Verificacion;

import viverbot.DTO.PlantaDTO;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.Magnitudes.Altura;

public class StrategySeguimientoNull implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Altura actual, Altura esperada , PlantaDTO planta) {
		return new EstadoAlturaNoComparada("SeguimientoNull");
		
	}

}
