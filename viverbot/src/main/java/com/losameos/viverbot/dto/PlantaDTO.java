package com.losameos.viverbot.dto;

import com.losameos.viverbot.Model.Ubicacion;

public class PlantaDTO {
	
	private Ubicacion ubicacion;
	
	public PlantaDTO(Ubicacion ubicacion)
	{
		this.ubicacion = ubicacion;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
}
