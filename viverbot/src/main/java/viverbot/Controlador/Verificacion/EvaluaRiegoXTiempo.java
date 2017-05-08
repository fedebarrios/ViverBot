package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;

public class EvaluaRiegoXTiempo extends EvaluaRiegoDecorator{
	ControlTiempo controlTiempo;

	public EvaluaRiegoXTiempo(RiegoValidable riegoValidable) {
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
		
 		return getRiegoValidable().cantidadOptimaRiego().nivelar(nivel);

	}

	public ControlTiempo getControlTiempo() {
		return controlTiempo;
	}

	public void setControlTiempo(ControlTiempo controlTiempo) {
		this.controlTiempo = controlTiempo;
	}
	
	
	
}
