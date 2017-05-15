package viverbot.Archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class GatewayConfiguracion {
	
	public static String getDirectorio(int posicion){
		Properties propiedades = new Properties();
	    InputStream entrada = null;									
	    try {
	    	entrada = new FileInputStream("src/main/java/viverbot/Archivos/configuracion.properties");	
	        propiedades.load(entrada);
	        if(posicion == 1){
	        	entrada.close();
	        	return propiedades.getProperty("directorioPrimario");
	        } else if (posicion == 2){
	        	entrada.close();
	        	return propiedades.getProperty("directorioSecundario");
	        } else if (posicion == 3){
	        	entrada.close();
	        	return propiedades.getProperty("directorioTerciario");	
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } 
		return null;
	}

	public static void setearDirectorio(String pathDirectorio, int posicion){
		Properties propiedades = new Properties();
		OutputStream output = null;								
	    try {
	    	output = new FileOutputStream("src/main/java/viverbot/Archivos/configuracion.properties");	
	        if(posicion == 1){
	        	propiedades.setProperty("directorioPrimario", pathDirectorio);
	        } else if (posicion == 2){
	        	propiedades.setProperty("directorioSecundario", pathDirectorio);
	        } else{
	        	propiedades.setProperty("directorioTerciario", pathDirectorio);	
	        }
	        propiedades.store(output, null);
            output.close();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
}

