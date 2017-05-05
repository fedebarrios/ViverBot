package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;

public abstract class EvaluaRiegoDecorator implements RiegoValidable {
	private RiegoValidable riegoValidable;

	public EvaluaRiegoDecorator(RiegoValidable riegoValidable) {		
		this.riegoValidable = riegoValidable;
	}
	
	public RiegoValidable getRiegoValidable(){
		return riegoValidable;
	}
	
	
	public NivelRiego promediaNivel(NivelRiego nivel){
		NivelRiego nivelRiego=this.getRiegoValidable().cantidadOptimaRiego();
		
		switch (nivelRiego) 
		{
		case NULO:
			nivelRiego=NivelRiego.NULO;
		case NORMAL:
			nivelRiego=nivel;
		default:
			break;
			
		}
		
		return nivelRiego;
	}	
	
}
