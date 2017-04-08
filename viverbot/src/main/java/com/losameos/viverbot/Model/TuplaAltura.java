package com.losameos.viverbot.Model;

import com.losameos.viverbot.Model.Magnitudes.Altura;

public class TuplaAltura {
	
	private Altura altura;
	private int diaDeVida;
	
	public TuplaAltura (Altura a, int d){
		this.altura = a;
		this.diaDeVida = d;
	}

	public Altura getAltura() {
		return altura;
	}

	public void setAltura(Altura altura) {
		this.altura = altura;
	}

	public int getDiaDeVida() {
		return diaDeVida;
	}

	public void setDiaDeVida(int diaDeVida) {
		this.diaDeVida = diaDeVida;
	}
	
}
