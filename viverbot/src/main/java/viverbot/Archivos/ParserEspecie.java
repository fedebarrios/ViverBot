package viverbot.Archivos;

import viverbot.DAO.EspecieDAO;
import viverbot.DTO.EspecieDTO;

public class ParserEspecie extends Parser{
	
	public EspecieDTO parsearEspecie(String s){
		String[] datos = s.split(":");
		return new EspecieDTO(69,datos[0],datos[1],"");
	}
}
