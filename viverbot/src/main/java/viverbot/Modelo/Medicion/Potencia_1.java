package viverbot.Modelo.Medicion;

import viverbot.Interfaces.IPotencia;
import viverbot.Modelo.Magnitudes.Temperatura;

public class Potencia_1 implements IPotencia {

	@Override
	public Temperatura aplicarPotencia(AireAcondicionado aire, Temperatura temp) {
		aire.setPotenciaEstado(this);
		if (aire.getFrioCalorEstado().getClass() == Calor.class) {
			temp.setValor(temp.getValor() + 0.1);
			return temp;
		}
		temp.setValor(temp.getValor() - 0.1);
		return temp;
	}

	@Override
	public String toString() {
		return "Potencia 1";
	}

}
