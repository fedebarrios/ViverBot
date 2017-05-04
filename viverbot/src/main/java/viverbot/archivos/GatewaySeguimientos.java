package viverbot.archivos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GatewaySeguimientos {
	
	public static String getStub(){
		Properties propiedades = new Properties();
	    InputStream entrada = null;
	    String ret = "";

	    try {
	        entrada = new FileInputStream("src/main/java/com/losameos/viverbot/archivos/StubSeguimientos.properties");
	        propiedades.load(entrada);
	        ret = propiedades.getProperty("stub");
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
	    
	    return ret;
	}
	
}
