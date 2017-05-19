package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;
import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Modelo.Magnitudes.Medicion;

public class StrategyMetroDown implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Medicion actual, Medicion esperada , Planta planta) {
		return new EstadoAlturaNoComparada("MetroDown");
	}

}
