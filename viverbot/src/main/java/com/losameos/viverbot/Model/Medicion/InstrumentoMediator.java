package com.losameos.viverbot.Model.Medicion;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Sensores.InstrumentoFactory;
import com.losameos.viverbot.Model.Sensores.InstrumentoMedicion;

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

	public Magnitud tomarMedicion() {
		return this.instrumentoMedicion.getMedicion();
	}

	public InstrumentoMedicion getInstrumentoMedicion() {
		return instrumentoMedicion;
	}
	
	public ArrayList<Magnitud> tomarAlturas(){
		ArrayList<Magnitud> alturasActuales = new ArrayList<Magnitud> ();
		soporte = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
		plantas = new Plantas().obtenerPlantas();
		for (int i = 0 ; i < plantas.size() ; i++){
			soporte.mover(plantas.get(i).getUbicacion());
			alturasActuales.add(tomarMedicion());
		}
		return alturasActuales;
	}

}
