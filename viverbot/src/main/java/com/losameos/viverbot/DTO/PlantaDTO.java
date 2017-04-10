package com.losameos.viverbot.DTO;

import java.sql.Date;

public class PlantaDTO {
	
	private int codigoEspecie;
	private int codigoPlanta;
	private UbicacionDTO ubicacion;
	private Date fechaPlanta;
	
	public PlantaDTO(int codigoEspecie, int codigoPlanta, UbicacionDTO ubicacion, Date fechaPlanta)
	{
		this.codigoEspecie = codigoEspecie;
		this.ubicacion = ubicacion;
		this.fechaPlanta = fechaPlanta;
		this.codigoPlanta = codigoPlanta;
	}

	public int getCodigoPlanta() {
		return codigoPlanta;
	}

	public void setCodigoPlanta(int codigoPlanta) {
		this.codigoPlanta = codigoPlanta;
	}

	public Date getFechaPlanta() {
		return fechaPlanta;
	}

	public void setFechaPlanta(Date fechaPlanta) {
		this.fechaPlanta = fechaPlanta;
	}

	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCodigo() {
		return codigoEspecie;
	}

	public void setCodigo(Integer codigo) {
		this.codigoEspecie = codigo;
	}
}
