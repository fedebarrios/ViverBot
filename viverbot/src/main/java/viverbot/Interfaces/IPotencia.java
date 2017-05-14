package viverbot.Interfaces;

import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Medicion.AireAcondicionado;

public interface IPotencia {

	public Medicion aplicarPotencia(AireAcondicionado aire);
}
