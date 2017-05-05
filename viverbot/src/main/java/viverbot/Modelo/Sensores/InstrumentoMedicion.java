package viverbot.Modelo.Sensores;

import viverbot.Modelo.Magnitudes.Magnitud;

public abstract class  InstrumentoMedicion {

	public Magnitud getMedicion() {
		return obtenerMedicion();
	}

	protected Magnitud obtenerMedicion(){
		return null;
	}
	
	
	

}
