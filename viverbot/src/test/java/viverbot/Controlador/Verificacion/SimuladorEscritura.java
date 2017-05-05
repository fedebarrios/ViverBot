package viverbot.Controlador.Verificacion;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class SimuladorEscritura {
	String in;
	public SimuladorEscritura(String in){
		this.in = in;
	}
	
	public void escribir(){
		InputStream testInput = null;
		try {
			testInput = new ByteArrayInputStream( in.getBytes("UTF-8") );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
		    System.setIn( testInput );
		} finally {
			
		}
	}
}
