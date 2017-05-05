package viverbot.Controlador.Verificacion;

import viverbot.Model.NivelRiego;

public class EvaluaRiego  extends AnalizadorRiego{
	
	
	public EvaluaRiego() {
	}

	public NivelRiego cantidadOptimaRiego(){
		return NivelRiego.NORMAL;
	}
}
