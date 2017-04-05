package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.Model.Magnitudes.Humedad;

public class EstadoHumedad {
	
	Humedad valor;
	Boolean optimo;
	Ubicacion ubicacion;
	
	
	public EstadoHumedad(Humedad valor, Boolean optimo, Ubicacion ubicacion) {
		this.valor = valor;
		this.optimo = optimo;
		this.ubicacion = ubicacion;
	}
	public Humedad getHumedad() {
		return valor;
	}
	public void setValor(Humedad valor) {
		this.valor = valor;
	}
	public Boolean getOptimo() {
		return optimo;
	}
	public void setOptimo(Boolean optimo) {
		this.optimo = optimo;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
