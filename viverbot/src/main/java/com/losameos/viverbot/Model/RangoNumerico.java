package com.losameos.viverbot.Model;

public class RangoNumerico {
	Double minimo;
	Double maximo;

	public RangoNumerico(Double minimo, Double maximo) {
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public Double getMinimo() {
		return minimo;
	}

	public void setMinimo(Double minimo) {
		this.minimo = minimo;
	}

	public Double getMaximo() {
		return maximo;
	}

	public void setMaximo(Double maximo) {
		this.maximo = maximo;
	}

}
