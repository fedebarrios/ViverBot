package viverbot.Archivos;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Interfaces.IParser;

public class ParserEstados implements IParser<EstadoAltura>{
	
	public EstadoAltura parsear(String s, int valuemin, int valuemax){
		EstadoAltura estado = new EstadoAltura();
		estado.setEstado(s);
		estado.setValorMin(valuemin);
		estado.setValorMax(valuemax);
		return estado;
	}

	@Override
	public EstadoAltura parsear(String s) {
		return null;
	}
	
}
