package viverbot.Controller.Verificacion;

import viverbot.Model.NivelRiego;

public class ValidaRiego  extends AnalizadorRiego{
	
	
	public ValidaRiego() {
	}

	public NivelRiego cantidadOptimaRiego(){
		return NivelRiego.NORMAL;
	}
}
