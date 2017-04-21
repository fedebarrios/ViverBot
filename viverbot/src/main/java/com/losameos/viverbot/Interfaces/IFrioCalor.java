package com.losameos.viverbot.Interfaces;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public interface IFrioCalor {

	public Temperatura interferirClima(Temperatura temp, IPotencia potencia);

}
