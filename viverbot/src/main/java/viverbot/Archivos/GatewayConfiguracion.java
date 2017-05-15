package viverbot.Archivos;

import java.io.FileInputStream;
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
	
	public static String getDirectorioSecundario(){
		Properties propiedades = new Properties();
	    InputStream entrada = null;									
	    try {
	    	entrada = new FileInputStream("src/test/java/viverbot/Archivos/configuracion.properties");	
	        propiedades.load(entrada);
	        return propiedades.getProperty("directorioSecundario");
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
	
	public static String getDirectorioTerciario(){
		Properties propiedades = new Properties();
	    InputStream entrada = null;									
	    try {
	    	entrada = new FileInputStream("src/test/java/viverbot/Archivos/configuracion.properties");	
	        propiedades.load(entrada);
	        return propiedades.getProperty("directorioTerciario");
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
	
	public void setearDirectorio(String pathDirectorio, int posicion){
		Properties propiedades = new Properties();
	    InputStream entrada = null;									
	    try {
	    	entrada = new FileInputStream("src/test/java/viverbot/Archivos/configuracion.properties");	
	        propiedades.load(entrada);
	        if(posicion == 1){
	        	propiedades.setProperty("directorioPrimario", pathDirectorio);
	        } else if (posicion == 2){
	        	propiedades.setProperty("directorioSecundario", pathDirectorio);
	        } else{
	        	propiedades.setProperty("directorioTerciario", pathDirectorio);	
	        }
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
	}
}

