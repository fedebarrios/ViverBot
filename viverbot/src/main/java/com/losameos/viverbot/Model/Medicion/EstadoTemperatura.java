package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class EstadoTemperatura {
	private Temperatura temperatura;
	private Boolean optima;

	public EstadoTemperatura(Temperatura temperatura, Boolean optima) {
		super();
		this.temperatura = temperatura;
		this.optima = optima;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public Boolean getOptima() {
		return optima;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

	public void setOptima(Boolean optima) {
		this.optima = optima;
	}

	@Override
	public boolean equals(Object e) {
		EstadoTemperatura estado =  (EstadoTemperatura) e;
		boolean ret = true;
		if(this.temperatura.getValor() != estado.getTemperatura().getValor() || 
				this.getOptima() != estado.getOptima()){
			ret = false;
		}
		
		return ret;
	}

}
