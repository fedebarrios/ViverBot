package viverbot.Modelo.Medicion;

import java.util.ArrayList;

import viverbot.DTO.Planta;
import viverbot.Model.Plantas;
import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Sensores.InstrumentoFactory;
import viverbot.Modelo.Sensores.InstrumentoMedicion;

public class InstrumentoMediator {
	protected InstrumentoMedicion instrumentoMedicion;
	protected String tipoValor;
	protected SoporteMovible soporte;
	protected ArrayList<Planta> plantas;

	//revisar si esto se va a seguir utilizando
	public InstrumentoMediator() {
		this.tipoValor = "";
	}

	public InstrumentoMediator(Magnitudes m) {
		this.instrumentoMedicion = InstrumentoFactory.crearInstrumento(m);
	}

	public Medicion tomarMedicion() {
		return this.instrumentoMedicion.getMedicion();
	}

	public InstrumentoMedicion getInstrumentoMedicion() {
		return instrumentoMedicion;
	}
	
	public Medicion tomarAltura(Planta p){
		soporte = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
		plantas = new Plantas().obtenerPlantas();
		soporte.mover(p.getUbicacion());
		return tomarMedicion();
	}
	
	

}
