package viverbot.Model;

import java.util.Scanner;

public class LectorConsola {
	private static LectorConsola lector;
	private Scanner entradaEscaner;
	
	private LectorConsola(){
		entradaEscaner =  new Scanner (System.in);
	}
	
	public static LectorConsola getInstance(){
		if(lector == null){
			lector = new LectorConsola();
		}
		return lector;
	}
	
	public String leerLinea(){
		return entradaEscaner.nextLine().toLowerCase();
	}
}
