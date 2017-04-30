package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Interfaces.IAnalisisAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class StrategySeguimientoNull implements IAnalisisAltura{

	@Override
	public void analizar(Magnitud m, SeguimientoAltura seguimiento) {
		System.out.println("-------------------------------------------------");
		System.out.println("No existe un seguimiento vinculado a la planta actual");
		//Alertador.alertar();
		
	}

}
