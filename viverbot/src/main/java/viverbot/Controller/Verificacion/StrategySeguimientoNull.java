package viverbot.Controller.Verificacion;

import viverbot.Interfaces.IAnalisisAltura;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.Magnitudes.Magnitud;

public class StrategySeguimientoNull implements IAnalisisAltura{

	@Override
	public EstadoAltura analizar(Magnitud m, SeguimientoAltura seguimiento) {
		return new EstadoAlturaNoComparada("SeguimientoNull");
		
	}

}