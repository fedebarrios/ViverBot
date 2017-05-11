package viverbot.Modelo.Medicion;

import viverbot.Interfaces.IFrioCalor;

public class Frio implements IFrioCalor {

	@Override
	public void anunciarEstado(AireAcondicionado aire) {
		aire.setFrioCalorEstado(this);
		System.out.println("El aire se encuentra en frio");
	}

	@Override
	public String toString() {
		return "Frio";
	}

}
