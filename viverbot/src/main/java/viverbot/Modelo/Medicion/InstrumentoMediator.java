package viverbot.Modelo.Medicion;

import java.util.ArrayList;

import viverbot.DTO.PlantaDTO;
import viverbot.Model.Plantas;
import viverbot.Model.SoporteFactory;
import viverbot.Model.SoporteMovible;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Magnitudes;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Sensores.InstrumentoFactory;
import viverbot.Modelo.Sensores.InstrumentoMedicion;

public class InstrumentoMediator {
	protected InstrumentoMedicion instrumentoMedicion;
	protected String tipoValor;
	protected SoporteMovible soporte;
	protected ArrayList<PlantaDTO> plantas;

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
	
	public ArrayList<Medicion> tomarAlturas(){
		ArrayList<Medicion> alturasActuales = new ArrayList<Medicion> ();
		soporte = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
		plantas = new Plantas().obtenerPlantas();
		for (int i = 0 ; i < plantas.size() ; i++){
			soporte.mover(plantas.get(i).getUbicacion());
			alturasActuales.add(tomarMedicion());
		}
		return alturasActuales;
	}

}
