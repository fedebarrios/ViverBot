package com.losameos.viverbot.DTO;

import com.losameos.viverbot.Model.Ubicacion;

public class PlantaDTO {
	
	private Integer codigo;
	private Ubicacion ubicacion;
	
	public PlantaDTO(Integer codigo, Ubicacion ubicacion)
	{
		this.codigo = codigo;
		this.ubicacion = ubicacion;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	
}
