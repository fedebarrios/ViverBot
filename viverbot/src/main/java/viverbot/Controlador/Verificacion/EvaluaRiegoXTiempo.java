package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;

public class EvaluaRiegoXTiempo extends EvaluaRiegoDecorator{
	ControlTiempo controlTiempo=new ControlTiempo();

	public EvaluaRiegoXTiempo(RiegoValidable riegoValidable) {
		super(riegoValidable);
	}
	
	public NivelRiego cantidadOptimaRiego(){
		
		NivelRiego nivel=getRiegoValidable().cantidadOptimaRiego();		
		if(controlTiempo.esDeDia()&&controlTiempo.esVerano()){
			nivel=nivel.aumentar();
		}else if(!controlTiempo.esDeDia()&&controlTiempo.esInvierno()){
			nivel=nivel.bajar();
		}
		
 		return nivel;

	}

	public ControlTiempo getControlTiempo() {
		return controlTiempo;
	}

	public void setControlTiempo(ControlTiempo controlTiempo) {
		this.controlTiempo = controlTiempo;
	}
	
	
	
}
