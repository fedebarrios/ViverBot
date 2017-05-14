package viverbot.Modelo.Medicion;

import viverbot.Interfaces.IFrioCalor;

public class Calor implements IFrioCalor {
	
	@Override
	public void definirEstado(AireAcondicionado aire) {
		aire.setFrioCalorEstado(this);
		System.out.println("El aire se encuentra en calor");
	}

	@Override
	public String toString() {
		return "Calor";
	}

}
