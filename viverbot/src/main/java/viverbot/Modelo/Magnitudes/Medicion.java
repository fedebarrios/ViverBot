package viverbot.Modelo.Magnitudes;

public class Medicion {
	
	private Double valor;
	Magnitudes tipo;
	
	public Medicion(Double v, Magnitudes m ){
		this.valor = v;
		this.tipo = m;
	}

	public Double getValor() {
		return valor;
	}

	public Magnitudes getTipo() {
		return tipo;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Medicion)){
			return false;
		}
		else{
			Medicion m = (Medicion) o;
			return m.getValor().doubleValue() == this.getValor().doubleValue()
					|| m.getTipo() == this.getTipo();
		}
	}
	
	
	
	
	

}
