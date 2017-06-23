package viverbot.Archivos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GatewayConfiguracion{
	
	public static List<String> getDirectorios(){
		List<String> directorios = new ArrayList<String>() ;
		FileReader f;
		try {
			f = new FileReader("src/main/java/viverbot/Archivos/Directorios.txt");
			BufferedReader b = new BufferedReader(f);
			String line = "";
			while ((line = b.readLine()) != null) {
				directorios.add(line);
			}
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return directorios;
	}

	public static void agregarDirectorio(String pathDirectorio){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("src/main/java/viverbot/Archivos/Directorios.txt",true);
            pw = new PrintWriter(fichero);
            pw.println(pathDirectorio);
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
	}

	public static void borrarDirectorio(int i) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("src/main/java/viverbot/Archivos/Directorios.txt",true);
            pw = new PrintWriter(fichero);
            List<String> directorios = GatewayConfiguracion.getDirectorios();
            limpiar();
    		for(int index=0; index< directorios.size() ; index++){
                if(index!=i) pw.println(directorios.get(index));
    		}
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	}

	public static void limpiar() {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("src/main/java/viverbot/Archivos/Directorios.txt");
            pw = new PrintWriter(fichero);
            pw.print("");
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	}

	public static String getDirectorio(int i) {
		List<String> directorios = GatewayConfiguracion.getDirectorios();
		return directorios.get(i);
	}
	

}

