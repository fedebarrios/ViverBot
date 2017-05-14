package viverbot.Archivos;

import viverbot.DTO.EspecieDTO;
import viverbot.Interfaces.IParser;

public class ParserEspecie implements IParser<EspecieDTO>{
	
	public EspecieDTO parsear(String s){
		String[] datos = s.split(":");
		datos[0] = datos[0].substring(1);
		EspecieDTO ret = new EspecieDTO(69,datos[0],datos[1],"");
		return ret;
	}
}
