package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Interfaces.IFrioCalorState;
import com.losameos.viverbot.Interfaces.IPotencia;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AireAcondicionadoState {
	private IPotencia potencia;
	private IFrioCalorState estado;

	public AireAcondicionadoState() {
		this.potencia = null;
		this.estado = null;
	}

	public void frioState() {
		this.estado = new FrioState();
	}

	public void calorState() {
		this.estado = new CalorState();
	}

	public void interferirTemperatura(Temperatura temp) {
		this.estado.interferirEnElClima(temp, this.potencia);
	}

	public void estableceCalculadorDePotencia(Temperatura temp, RangoNumerico rango) {
		if (this.estado.getClass() == FrioState.class) {
			if (temp.getValor() - rango.getMaximo() <= 1.0) {
				this.potencia = new Potencia0Strategy();
			} else if (temp.getValor() - rango.getMaximo() > 1.0 && temp.getValor() - rango.getMaximo() <= 2.5) {
				this.potencia = new Potencia1Strategy();
			} else if (temp.getValor() - rango.getMaximo() > 2.5 && temp.getValor() - rango.getMaximo() <= 4.0) {
				this.potencia = new Potencia2Strategy();
			} else if (temp.getValor() - rango.getMaximo() > 4.0) {
				this.potencia = new Potencia3Strategy();
			}
		} else {
			if (rango.getMinimo() - temp.getValor() <= 1.0) {
				this.potencia = new Potencia0Strategy();
			} else if (rango.getMinimo() - temp.getValor() > 1.0 && rango.getMinimo() - temp.getValor() <= 2.5) {
				this.potencia = new Potencia1Strategy();
			} else if (rango.getMinimo() - temp.getValor() > 2.5 && rango.getMinimo() - temp.getValor() <= 4.0) {
				this.potencia = new Potencia2Strategy();
			} else if (rango.getMinimo() - temp.getValor() > 4.0) {
				this.potencia = new Potencia3Strategy();
			}
		}
	}

}
