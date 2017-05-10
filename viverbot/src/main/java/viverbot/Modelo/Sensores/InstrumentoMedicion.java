package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Medicion;

public abstract class  InstrumentoMedicion {

	public Medicion getMedicion() {
		return obtenerMedicion();
	}

	protected Medicion obtenerMedicion(){
		return null;
	}
	
	
	

}
