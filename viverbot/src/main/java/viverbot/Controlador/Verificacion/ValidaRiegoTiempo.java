package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;

public class ValidaRiegoTiempo extends ValidaRiegoDecorator{
	ControlTiempo controlTiempo;

	public ValidaRiegoTiempo(RiegoValidable riegoValidable) {
		super(riegoValidable);
		controlTiempo=new ControlTiempo();
	}
	
	public NivelRiego cantidadOptimaRiego(){
		
		NivelRiego nivel=NivelRiego.NORMAL;		
		if(controlTiempo.esDeDia()&&controlTiempo.esVerano()){
			nivel =NivelRiego.AUMENTAR;
		}else if(!controlTiempo.esDeDia()&&controlTiempo.esInvierno()){
			nivel =NivelRiego.BAJAR;
		}
		
		return promediaNivel(nivel);
	}

	public ControlTiempo getControlTiempo() {
		return controlTiempo;
	}
	
}
