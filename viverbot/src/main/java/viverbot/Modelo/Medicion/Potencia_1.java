package viverbot.Modelo.Medicion;

import viverbot.Interfaces.Potencia;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class Potencia_1 implements Potencia {

	@Override
	public Medicion aplicarPotencia(AireAcondicionado aire) {
		Medicion ret = new Medicion(0.006, Magnitud.TEMPERATURA);
		aire.setPotencia(this);
		return ret;
	}

	@Override
	public String toString() {
		return "1";
	}

}
