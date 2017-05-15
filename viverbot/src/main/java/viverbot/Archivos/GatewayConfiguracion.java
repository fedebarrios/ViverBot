package viverbot.Archivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GatewayConfiguracion {
	
	public static String getDirectorioPrimario(){
		Properties propiedades = new Properties();
	    InputStream entrada = null;									
	    try {
	    	entrada = new FileInputStream("src/test/java/viverbot/Archivos/configuracion.properties");	
	        propiedades.load(entrada);
	        return propiedades.getProperty("directorioPrimario");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (entrada != null) {
	            try {
	                entrada.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		return null;
	}
}

