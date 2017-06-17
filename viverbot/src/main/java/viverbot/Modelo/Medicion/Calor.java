package viverbot.Modelo.Medicion;

import viverbot.Interfaces.FrioCalor;

public class Calor implements FrioCalor {
	
	@Override
	public void definirEstado(AireAcondicionado aire) {
		aire.setEstado(this);
	}

	@Override
	public String toString() {
		return "Calor";
	}

}
