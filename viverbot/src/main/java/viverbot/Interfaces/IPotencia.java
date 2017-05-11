package viverbot.Interfaces;

import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.AireAcondicionado;

public interface IPotencia {

	public Temperatura aplicarPotencia(AireAcondicionado aire, Temperatura temp);
}
