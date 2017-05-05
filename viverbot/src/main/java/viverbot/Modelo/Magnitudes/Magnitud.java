package viverbot.Model.Magnitudes;

public abstract class Magnitud {

	protected Double valor;

	public Magnitud(Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {
		Magnitud m =  (Magnitud) obj;
		return this.getValor().equals(m.getValor());
	}

	
}
