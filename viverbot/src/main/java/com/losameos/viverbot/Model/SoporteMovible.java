package com.losameos.viverbot.Model;

import com.losameos.viverbot.Interfaces.IMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;
import com.losameos.viverbot.Model.Medicion.Colector;

public class SoporteMovible implements IMovible{

	private Colector colector;
	private Ubicacion ubicacion;
	private Ubicacion defaultUbicacion= new Ubicacion(0,0);
	
	public SoporteMovible(Magnitudes m){
		this.colector = new Colector(m);
		this.ubicacion = defaultUbicacion;
	}
	
	@Override
	public void mover(Ubicacion u) {
		// TODO Auto-generated method stub
		IMovible.super.mover(u);
	}

	public Colector getColector() {
		return colector;
	}

	public void setColector(Colector colector) {
		this.colector = colector;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
	

}
