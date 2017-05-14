package viverbot.Model;

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

	public Double getMaximo() {
		return maximo;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof RangoNumerico)){
			return false;
		}
		else{
			RangoNumerico r = (RangoNumerico) o;
			return r.getMinimo().equals(this.getMinimo()) && r.getMaximo().equals(this.getMaximo());
		}
		
	}
	
	

}
