package viverbot.Archivos;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import viverbot.Controlador.Verificacion.Verificador;
import viverbot.Model.Log;

public class ValidadorHistorial {
	private Logger logger;
	
	public ValidadorHistorial(){
		logger = Log.getLog(ValidadorHistorial.class);
	}
	
	public boolean validarCantidadDatos(String entrada) {
		int cant=0;
		for(char c : entrada.toCharArray()){
			if(c == ':') cant++;
		}
		return cant==1;
	}
	
	protected boolean validarHistorial(List<String> entradas){
		Pattern patron = Pattern.compile("[h][\\d]*[:][\\d]*[.][\\d]*");
		boolean esValido = true;
		for (String s : entradas){
			if ( !patron.matcher(s).matches() ){
				if (!validarInfoEspecie(s)){
					esValido = false;
				}
			}
			if(!esValido){
				if(!validarCantidadDatos(s)){
					logger.error("Debe ingresar dos datos por fila");
				}
			}
		}
		return esValido;
	}
	
	protected boolean validarInfoEspecie(String s){
		Pattern patron = Pattern.compile("[e|E][a-z|A-Z]*[:][a-z|A-Z]*");
		boolean tieneFormatoValido = false;
		if ( patron.matcher(s).matches()) tieneFormatoValido = true;
		return tieneFormatoValido;
	}
}
