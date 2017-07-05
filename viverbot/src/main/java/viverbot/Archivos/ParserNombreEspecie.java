package viverbot.Archivos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import viverbot.Model.Log;

public class ParserNombreEspecie {
	protected static Logger logger  = Log.getLog(LectorArchivo.class);
	
	public static String parsearNombreEspecie(String lectura) throws Exception{
		Pattern p = Pattern.compile("Codigo:\\(([0-9]+)\\)");
		Matcher m = p.matcher(lectura);
		String valor = "";
		while(m.find()) {
			valor = m.group(1);
		}
		if (valor.equals("")){
			logger.error("El codigo no es numerico o no esta seteado.");
			return "";
		}
		return valor;
	}
}
