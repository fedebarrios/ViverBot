package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Interfaces.IFrioCalorState;
import com.losameos.viverbot.Interfaces.IPotencia;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class CalorState implements IFrioCalorState {

	@Override
	public Temperatura interferirEnElClima(Temperatura temp, IPotencia potencia) {
		if (potencia.getClass() == Potencia0Strategy.class) {
			temp.setValor(temp.getValor() + 0.05);
			return temp;
		} else if (potencia.getClass() == Potencia1Strategy.class) {
			temp.setValor(temp.getValor() + 0.1);
			return temp;
		} else if (potencia.getClass() == Potencia2Strategy.class) {
			temp.setValor(temp.getValor() + 0.15);
			return temp;
		} else {
			temp.setValor(temp.getValor() + 0.2);
			return temp;
		}
	}

	@Override
	public String toString() {
		return "Calor";
	}
	
	

}
