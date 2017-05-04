package viverbot.Interfaces;

import viverbot.Controller.Verificacion.EstadoAltura;

import viverbot.Model.SeguimientoAltura;
import viverbot.Model.Magnitudes.Magnitud;

public interface IAnalisisAltura {
	
	public EstadoAltura analizar(Magnitud m, SeguimientoAltura seguimiento);
}
