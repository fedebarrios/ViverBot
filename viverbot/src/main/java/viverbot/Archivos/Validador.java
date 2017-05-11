package viverbot.Archivos;

import java.io.File;

public class Validador {
	
	public Validador(){
		
	}
	
	public boolean validarExtension(String path, String extension){
		if (path.endsWith(extension)){
			return true;
		}
		return false;
	}
	
	public boolean validarExistencia(String path){
		File archivo = new File(path);
		if( archivo.isFile()) return true;
		return false;
	}
}
