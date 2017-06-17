package viverbot.Modelo.Medicion;

import viverbot.Interfaces.Potencia;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class Potencia_1 implements Potencia {

	@Override
	public Medicion aplicarPotencia(AireAcondicionado aire) {
		Medicion ret = new Medicion(0.006, Magnitudes.TEMPERATURA);
		aire.setPotencia(this);
		return ret;
	}

	@Override
	public String toString() {
		return "1";
	}

}
