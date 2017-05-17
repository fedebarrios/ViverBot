package viverbot.Modelo.Medicion;

import viverbot.Interfaces.IFrioCalor;

public class Frio implements IFrioCalor {

	@Override
	public void definirEstado(AireAcondicionado aire) {
		aire.setEstado(this);
		System.out.println("El aire se encuentra en frio");
	}

	@Override
	public String toString() {
		return "Frio";
	}

}
