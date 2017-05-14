package viverbot.Modelo.Medicion;

import viverbot.Interfaces.IPotencia;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;

public class Potencia_2 implements IPotencia {

	@Override
	public Medicion aplicarPotencia(AireAcondicionado aire) {
		Medicion ret = new Medicion(0.15, Magnitudes.TEMPERATURA);
		aire.setPotenciaEstado(this);
		return ret;
	}

	@Override
	public String toString() {
		return "Potencia 2";
	}

}
