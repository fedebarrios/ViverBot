package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Interfaces.IAnalisisAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class StrategyMetroDown implements IAnalisisAltura{

	@Override
	public void analizar(Magnitud m, SeguimientoAltura seguimiento) {
		System.out.println("El metro esta averiado, o no existe planta para tomar la altura en esa posicion");
		//Alertador.alertar();
		
	}

}
