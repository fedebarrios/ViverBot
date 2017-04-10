package com.losameos.viverbot.Model.Magnitudes;

public class Temperatura extends Magnitud{

	public Temperatura(Double valor) {
		super(valor);
		
		
	}

	@Override
	public boolean equals(Object o) {
		
		return super.equals(o) && (o instanceof Temperatura);
	}
	
	
	
}
