package viverbot.Interfaces;

import viverbot.Model.Magnitudes.Temperatura;

public interface IFrioCalor {

	public Temperatura interferirClima(Temperatura temp, IPotencia potencia);

}
