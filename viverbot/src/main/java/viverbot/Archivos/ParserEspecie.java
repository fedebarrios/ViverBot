package viverbot.Archivos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import viverbot.DTO.EspecieDTO;
import viverbot.Interfaces.IParser;

public class ParserEspecie implements IParser<EspecieDTO>{
	
	public EspecieDTO parsear(String s) throws Exception{
		Pattern p = Pattern.compile("Especie:\\(([A-Za-z]+[,][A-Za-z]+)\\)");
		Matcher m = p.matcher(s);
		String match = "";
		while(m.find()) {
			match += m.group(1);
		}
		if (match.equals("")){
			throw new Exception("No existe informacion acerca de la especie");
		}
		String[] datosEspecie = match.split(",");
		EspecieDTO ret = new EspecieDTO(6,datosEspecie[0],datosEspecie[1],"");
		return ret;
	}
}
