package viverbot.Controlador.Verificacion;

import viverbot.DTO.PlantaDTO;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Modelo.Magnitudes.Altura;

public class StrategyMetroDown implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Altura actual, Altura esperada , PlantaDTO planta) {
		return new EstadoAlturaNoComparada("MetroDown");
	}

}
