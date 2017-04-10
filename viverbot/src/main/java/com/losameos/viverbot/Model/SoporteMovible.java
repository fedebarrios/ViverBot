package com.losameos.viverbot.Model;

import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Interfaces.IMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Medicion.Colector;

public class SoporteMovible implements IMovible{

	private Colector colector;
	private UbicacionDTO ubicacion;
	private UbicacionDTO defaultUbicacion= new UbicacionDTO(0,0);
	
	public SoporteMovible(Magnitudes m){
		this.colector = new Colector(m);
		this.ubicacion = defaultUbicacion;
	}
	
	@Override
	public void mover(UbicacionDTO u) {
		this.setUbicacion(u);
	}

	public Colector getColector() {
		return colector;
	}

	public void setColector(Colector colector) {
		this.colector = colector;
	}

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
	

}
