package viverbot.Archivos;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.EstadoAltura;
import viverbot.Model.Log;

public class ParserEstadosAltura {
	protected static Logger logger  = Log.getLog(LectorArchivo.class);
	
	public static ArrayList<EstadoAltura> parsearEstados(String lectura){
		Pattern p = Pattern.compile("Estados:\\(([A-Za-z,]+)\\)");
		Matcher m = p.matcher(lectura);
		String match = "";
		while(m.find()) {
			match += m.group(1);
		}
		ArrayList<EstadoAltura> estados = new ArrayList<EstadoAltura>();
		if (match.equals("")){
			logger.error("Los estados tienen caracteres no alfanumericos o no estan seteados.");
			return estados;
		}
		String[] estadosJuntados = match.split(",");
		for(int i = 0; i < estadosJuntados.length; i++){
			EstadoAltura estado = new EstadoAltura();
			estado.setEstado(estadosJuntados[i]);
			estados.add(estado);
		}
		return estados;
	}
}
