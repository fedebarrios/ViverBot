package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AireAcondicionado {
	private boolean on_off;
	private Potencia fan;
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

	public Potencia getFan() {
		return fan;
	}

	public void setFan(Potencia fan) {
		this.fan = fan;
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
