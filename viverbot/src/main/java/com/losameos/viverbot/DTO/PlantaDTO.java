package com.losameos.viverbot.DTO;

import java.sql.Date;

import com.losameos.viverbot.Model.Historial;
import com.losameos.viverbot.Model.Ubicacion;

public class PlantaDTO {
	
	private int codigoEspecie;
	private int codigoPlanta;
	private Ubicacion ubicacion;
	private Date fechaPlanta;
	private Historial historialOptimo;
	private Historial historialVerdadero;
	
	public PlantaDTO(int codigoEspecie, int codigoPlanta, Ubicacion ubicacion, Date fechaPlanta, Historial h1, Historial h2)
	{
		this.codigoEspecie = codigoEspecie;
		this.ubicacion = ubicacion;
		this.fechaPlanta = fechaPlanta;
		this.codigoPlanta = codigoPlanta;
		this.historialOptimo = h1;
		this.historialVerdadero = h2;
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

	public Historial getHistorialOptimo() {
		return historialOptimo;
	}

	public void setHistorialOptimo(Historial historialOptimo) {
		this.historialOptimo = historialOptimo;
	}

	public Historial getHistorialVerdadero() {
		return historialVerdadero;
	}

	public void setHistorialVerdadero(Historial historialVerdadero) {
		this.historialVerdadero = historialVerdadero;
	}
	
	
}
