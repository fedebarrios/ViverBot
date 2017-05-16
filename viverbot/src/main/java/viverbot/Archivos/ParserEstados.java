package viverbot.Archivos;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Interfaces.IParser;

public class ParserEstados implements IParser<EstadoAltura>{
	
	@Override
	public EstadoAltura parsear(String s){
		EstadoAltura estado = new EstadoAltura();
		estado.setEstado(s);
		return estado;
	}
	
	public Integer getCodigoEspecie(String[] s){
		return Integer.valueOf(s[0]);
	}
}
