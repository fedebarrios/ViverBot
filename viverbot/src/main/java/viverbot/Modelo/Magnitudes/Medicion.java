package viverbot.Modelo.Magnitudes;

public class Medicion {

	private Double valor;
	private Magnitud tipo;

	public Medicion(Double v, Magnitud m) {
		this.valor = v;
		this.tipo = m;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Magnitud getTipo() {
		return tipo;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Medicion)) {
			return false;
		} else {
			Medicion m = (Medicion) o;
			return m.getValor().doubleValue() == this.getValor().doubleValue() && m.getTipo() == this.getTipo();
		}
	}

}
