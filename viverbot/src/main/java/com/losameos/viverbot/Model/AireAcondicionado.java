package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AireAcondicionado {
	private boolean on_off;
	private Potencia potencia;
	private boolean frio_calor;
	private Temperatura temperatura;

	public AireAcondicionado() {

	}

	public boolean isOn_off() {
		return on_off;
	}

	public void setOn_off(boolean on_off) {
		this.on_off = on_off;
	}

	public Potencia getPotencia() {
		return potencia;
	}

	public void setPotencia(Potencia potencia) {
		this.potencia = potencia;
	}

	public boolean isFrio_calor() {
		return frio_calor;
	}

	public void setFrio_calor(boolean frio_calor) {
		this.frio_calor = frio_calor;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

}
