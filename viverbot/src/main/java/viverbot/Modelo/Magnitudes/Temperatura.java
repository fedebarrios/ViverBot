package viverbot.Modelo.Magnitudes;

public class Temperatura extends MagnitudPorFavorNoUsenEstaCosaYUsenMeidcion{

	public Temperatura(Double valor) {
		super(valor);
		
		
	}

	@Override
	public boolean equals(Object o) {
		
		return (o instanceof Temperatura) && super.equals(o) ;
	}
	
	
	
}
