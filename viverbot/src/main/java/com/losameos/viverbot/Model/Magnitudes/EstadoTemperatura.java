package com.losameos.viverbot.Model.Magnitudes;

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
	
	

}
