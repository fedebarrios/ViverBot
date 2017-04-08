package com.losameos.viverbot.Model;

public class Calefaccion {
	// Potencia0 implica que el caloventor se encuentra apagado
	private boolean apagado;
	private Potencia potencia_ventiladores;
	private int temperatura_resistencia;

	public Calefaccion() {

	}

	public Calefaccion(Potencia potencia_ventiladores, int temperatura_resistencia) {
		this.potencia_ventiladores = potencia_ventiladores;
		this.temperatura_resistencia = temperatura_resistencia;
	}

	public boolean isApagado() {
		return apagado;
	}
	
	private void setApagado(boolean apagado){
		this.apagado = apagado;
	}

	public Potencia getPotencia_ventiladores() {
		return potencia_ventiladores;
	}

	public void setPotencia_ventiladores(Potencia potencia_ventiladores) {
		if (potencia_ventiladores == Potencia.POTENCIA0) {
			setApagado(true);
			this.potencia_ventiladores = potencia_ventiladores;
		} else
			this.potencia_ventiladores = potencia_ventiladores;
			setApagado(false);
	}

	public int getTemperatura_resistencia() {
		return temperatura_resistencia;
	}

	public void setTemperatura_resistencia(int temperatura_resistencia) {
		this.temperatura_resistencia = temperatura_resistencia;
	}

}
