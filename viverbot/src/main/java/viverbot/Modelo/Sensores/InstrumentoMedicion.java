package viverbot.Model.Sensores;

import viverbot.Model.Magnitudes.Magnitud;

public abstract class  InstrumentoMedicion {

	public Magnitud getMedicion() {
		return obtenerMedicion();
	}

	protected Magnitud obtenerMedicion(){
		return null;
	}
	
	
	

}
