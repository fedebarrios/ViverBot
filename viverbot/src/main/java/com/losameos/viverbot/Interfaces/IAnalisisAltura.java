package com.losameos.viverbot.Interfaces;

import com.losameos.viverbot.Controller.Verificacion.EstadoAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public interface IAnalisisAltura {
	
	public EstadoAltura analizar(Magnitud m, SeguimientoAltura seguimiento);
}
