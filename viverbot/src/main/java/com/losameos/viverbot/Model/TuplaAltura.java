package com.losameos.viverbot.Model;

import java.util.Date;

import com.losameos.viverbot.Model.Magnitudes.Altura;

public class TuplaAltura {
	
	private Altura altura;
	private Date diaDeVida;
	
	public TuplaAltura (Altura a, Date d){
		this.altura = a;
		this.diaDeVida = d;
	}

	public Altura getAltura() {
		return altura;
	}

	public void setAltura(Altura altura) {
		this.altura = altura;
	}

	public Date getDiaDeVida() {
		return diaDeVida;
	}

	public void setDiaDeVida(Date diaDeVida) {
		this.diaDeVida = diaDeVida;
	}
	
}
