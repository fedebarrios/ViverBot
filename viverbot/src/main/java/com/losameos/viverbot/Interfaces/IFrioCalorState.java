package com.losameos.viverbot.Interfaces;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public interface IFrioCalorState {

	public Temperatura interferirEnElClima(Temperatura temp, IPotencia potencia);

}
