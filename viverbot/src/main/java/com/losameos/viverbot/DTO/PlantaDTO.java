package com.losameos.viverbot.DTO;

import java.sql.Date;
import com.losameos.viverbot.Model.Ubicacion;

public class PlantaDTO {
	
	private Integer codigo;
	private Ubicacion ubicacion;
	private Date fechaPlanta;
	
	public PlantaDTO(Integer codigo, Ubicacion ubicacion)
	{
		this.codigo = codigo;
		this.ubicacion = ubicacion;
	}
	
	public PlantaDTO(Integer codigo, Ubicacion ubicacion, Date fechaPlanta)
	{
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.fechaPlanta = fechaPlanta;
	}

	public Date getFechaPlanta() {
		return fechaPlanta;
	}

	public void setFechaPlanta(Date fechaPlanta) {
		this.fechaPlanta = fechaPlanta;
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
