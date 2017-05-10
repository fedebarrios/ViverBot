package viverbot.Controlador.Verificacion;

import viverbot.DTO.PlantaDTO;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Modelo.Magnitudes.Medicion;

public class StrategyMetroDown implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Medicion actual, Medicion esperada , PlantaDTO planta) {
		return new EstadoAlturaNoComparada("MetroDown");
	}

}
