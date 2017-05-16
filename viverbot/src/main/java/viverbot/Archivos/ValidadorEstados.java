package viverbot.Archivos;

import java.util.List;

import org.apache.log4j.Logger;

import viverbot.Model.Log;

public class ValidadorEstados {
	
	protected Logger logger;
	public ValidadorEstados(){
		logger = Log.getLog(LectorTxt.class);
	}
	
	protected boolean validarEstados(List<String[]> data){
		String[] valores = data.get(0);
		String[] estados = data.get(1);
		String codigo = data.get(2)[0];
        for (int i = 0; i < valores.length; i++){
        	if (!valores[i].matches("\\d+")){
        		logger.info("Ingreso un valor que no es numerico para la lista de valores.");
        		return false;
        	}
        }
        for (int i = 0; i < estados.length; i++){
        	if (!estados[i].matches("^[\\w,]*$")){
        		logger.info("Ingreso un nombre con caracteres no alfanumericos.");
        		return false;
        	}
        }
        if (estados.length == valores.length || estados.length < valores.length || (estados.length - valores.length) > 1){
        	logger.info("La cantidad de valores debe ser menor en uno a la cantidad de estados.");
    		return false;
        }
        if (!codigo.matches("\\d+")){
        	logger.info("El codigo de especie no es numerico.");
        	return false;
        }
        return true;
	}
}
