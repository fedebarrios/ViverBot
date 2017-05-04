package viverbot.Model.Magnitudes;

public class Humedad extends Magnitud{

	public Humedad(Double valor) {
		super(valor);
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return (o instanceof Humedad) && super.equals(o);
	}
	
	
	
}
