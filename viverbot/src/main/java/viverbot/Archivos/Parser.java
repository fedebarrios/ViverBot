package viverbot.Archivos;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	public Parser(){
		
	}
	
	public String[] separarDato(String s){
		String[] datos = s.split(":");
		return datos;
	}
	
	public List<String> separarEntradas(String s){
		List<String> entradas = new ArrayList<String>();
		int aux = 0;
		for( int i = 0 ; i< s.length() ; i++){
			if( s.charAt(i) == '/' ){
				entradas.add(s.substring(aux, i));
				aux = i+1;
			}
		}
		entradas.add(s.substring(aux, s.length()));		
		return entradas;
		
	}
}
