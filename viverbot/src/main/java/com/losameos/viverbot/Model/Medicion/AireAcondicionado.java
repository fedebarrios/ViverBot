package com.losameos.viverbot.Model.Medicion;

import com.losameos.viverbot.Interfaces.IFrioCalor;
import com.losameos.viverbot.Interfaces.IPotencia;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;

public class AireAcondicionado {
	private IPotencia potencia;
	private IFrioCalor estado;

	public AireAcondicionado() {
	}

	public IPotencia getPotencia() {
		return potencia;
	}

	public IFrioCalor getEstado() {
		return estado;
	}

	public void interferirTemperatura(Temperatura temp) {
		this.estado.interferirClima(temp, this.potencia);
	}

	public void establecerPotenciaYEstado(Temperatura temp, RangoNumerico rango) {
		if (temp.getValor() > rango.getMaximo()) {
			this.estado = new Frio();
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
			this.estado = new Calor();
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

	// public void establecerPotencia(Temperatura temp, RangoNumerico rango) {
	// if (this.estado.getClass() == Frio.class) {
	// if (temp.getValor() - rango.getMaximo() <= 1.0) {
	// this.potencia = new Potencia0Strategy();
	// } else if (temp.getValor() - rango.getMaximo() > 1.0
	// && temp.getValor() - rango.getMaximo() <= 2.5) {
	// this.potencia = new Potencia1Strategy();
	// } else if (temp.getValor() - rango.getMaximo() > 2.5
	// && temp.getValor() - rango.getMaximo() <= 4.0) {
	// this.potencia = new Potencia2Strategy();
	// } else if (temp.getValor() - rango.getMaximo() > 4.0) {
	// this.potencia = new Potencia3Strategy();
	// }
	// } else {
	// if (rango.getMinimo() - temp.getValor() <= 1.0) {
	// this.potencia = new Potencia0Strategy();
	// } else if (rango.getMinimo() - temp.getValor() > 1.0
	// && rango.getMinimo() - temp.getValor() <= 2.5) {
	// this.potencia = new Potencia1Strategy();
	// } else if (rango.getMinimo() - temp.getValor() > 2.5
	// && rango.getMinimo() - temp.getValor() <= 4.0) {
	// this.potencia = new Potencia2Strategy();
	// } else if (rango.getMinimo() - temp.getValor() > 4.0) {
	// this.potencia = new Potencia3Strategy();
	// }
	// }
	// }

}
