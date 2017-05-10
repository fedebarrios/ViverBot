package viverbot.Model;

import viverbot.Modelo.Magnitudes.Medicion;

public class TuplaAltura {
	
	private Medicion altura;
	private int diaDeVida;
	
	public TuplaAltura (Medicion a, int d){
		this.altura = a;
		this.diaDeVida = d;
	}

	public Medicion getAltura() {
		return altura;
	}

	public void setAltura(Medicion altura) {
		this.altura = altura;
	}

	public int getDiaDeVida() {
		return diaDeVida;
	}

	public void setDiaDeVida(int diaDeVida) {
		this.diaDeVida = diaDeVida;
	}
	
}
