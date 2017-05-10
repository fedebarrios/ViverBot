package viverbot.Controlador.Verificacion;

public abstract class EvaluaRiegoDecorator implements RiegoValidable {
	private RiegoValidable riegoValidable;
	
	public EvaluaRiegoDecorator(RiegoValidable riegoValidable) {		
		this.riegoValidable = riegoValidable;
	}
	
	public RiegoValidable getRiegoValidable(){
		return riegoValidable;
	}
	
	
	
}
