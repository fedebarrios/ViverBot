package com.losameos.viverbot.Controller;

import com.losameos.viverbot.Interfaces.IControlClima;
import com.losameos.viverbot.Model.AireAcondicionado;
import com.losameos.viverbot.Model.Potencia;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AireAcondicionadoController implements IControlClima {
	private AireAcondicionado aireAcondicionado;

	public AireAcondicionadoController() {

	}

	@Override
	public void encenderAireAcondicionado() {
		this.aireAcondicionado.setOn_off(true);
	}

	@Override
	public void apagarAireAcondicionado() {
		this.aireAcondicionado.setOn_off(false);
	}

	@Override
	public void encenderFan(Potencia pot) {
		if (pot != Potencia.POTENCIA0) {
			this.aireAcondicionado.setFan(pot);
		} else
			throw new IllegalArgumentException("La potencia no puede ser 0");
	}

	@Override
	public void apagarFan() {
		this.aireAcondicionado.setFan(Potencia.POTENCIA0);
	}

	@Override
	public void aumentarTemperatura() {
		Double temp_double = this.aireAcondicionado.getTemperatura().getValor() + 1.0;
		Temperatura temp = new Temperatura(temp_double);
		this.aireAcondicionado.setTemperatura(temp);
	}

	@Override
	public void disminuirTemperatura() {
		Double temp_double = this.aireAcondicionado.getTemperatura().getValor() - 1.0;
		Temperatura temp = new Temperatura(temp_double);
		this.aireAcondicionado.setTemperatura(temp);

	}

	@Override
	public void cambiarTemperatura(Double temp_double) {
		Temperatura temp = new Temperatura(temp_double);
		this.aireAcondicionado.setTemperatura(temp);
	}

}
