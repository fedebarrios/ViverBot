package viverbot.Modelo.Magnitudes;

public abstract class MagnitudPorFavorNoUsenEstaCosaYUsenMeidcion {

	protected Double valor;

	public MagnitudPorFavorNoUsenEstaCosaYUsenMeidcion(Double valor) {
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
		MagnitudPorFavorNoUsenEstaCosaYUsenMeidcion m =  (MagnitudPorFavorNoUsenEstaCosaYUsenMeidcion) obj;
		return this.getValor().equals(m.getValor());
	}

	
}
