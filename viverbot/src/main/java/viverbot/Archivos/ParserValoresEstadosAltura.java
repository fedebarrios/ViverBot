package viverbot.Archivos;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import viverbot.Model.Log;

public class ParserValoresEstadosAltura {
	protected static Logger logger  = Log.getLog(LectorArchivo.class);
	
	public static ArrayList<Double> parsearValores(String lectura) throws Exception{	
		Pattern p = Pattern.compile("Valores:\\(([0-9,]+)\\)");
		Matcher m = p.matcher(lectura);
		String match = "";
		while(m.find()) {
			match += m.group(1);
		}
		ArrayList<Double> valores = new ArrayList<Double>();
		if (match.equals("")){
			logger.error("Los valores no son alfanumericos o no estan seteados.");
			return valores;
		}
		String[] valoresJuntados = match.split(",");
		for(int i = 0; i < valoresJuntados.length; i++){
			valores.add(Double.valueOf(valoresJuntados[i]));
		}
		return valores;
	}
}
