package com.losameos.viverbot.DTO;

import java.sql.Date;

import com.losameos.viverbot.Model.Historial;
import com.losameos.viverbot.Model.Ubicacion;

public class PlantaDTO {
	
	private int codigoEspecie;
	private int codigoPlanta;
	private Ubicacion ubicacion;
	private Date fechaPlanta;
	
	public PlantaDTO(int codigoEspecie, int codigoPlanta, Ubicacion ubicacion, Date fechaPlanta)
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

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCodigo() {
		return codigoEspecie;
	}

	public void setCodigo(Integer codigo) {
		this.codigoEspecie = codigo;
	}
}
