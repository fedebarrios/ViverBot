package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;

public class EvaluaRiego  implements RiegoValidable{
	
	
	public EvaluaRiego() {
	}

	public NivelRiego cantidadOptimaRiego(){
		return NivelRiego.NIVELNEUTRO;
	}
}
