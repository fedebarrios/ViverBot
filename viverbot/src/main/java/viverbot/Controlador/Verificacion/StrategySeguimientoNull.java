package viverbot.Controlador.Verificacion;

import viverbot.DTO.Planta;
import viverbot.Interfaces.AnalisisAltura;
import viverbot.Modelo.Magnitudes.Medicion;

public class StrategySeguimientoNull implements AnalisisAltura{

	@Override
	public EstadoAltura analizar(Medicion actual, Medicion esperada , Planta planta) {
		return new EstadoAlturaNoComparada("SeguimientoNull");
		
	}

}
