package viverbot.Interfaces;

import viverbot.Modelo.Magnitudes.Temperatura;

public interface IFrioCalor {

	public Temperatura interferirClima(Temperatura temp, IPotencia potencia);

}
