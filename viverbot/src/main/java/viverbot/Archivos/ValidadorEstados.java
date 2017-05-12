package viverbot.Archivos;

import java.util.List;

import viverbot.Controlador.Verificacion.Verificador;

public class ValidadorEstados {
	
	public ValidadorEstados(){
		
	}
	
	protected boolean validarEstados(List<String[]> data){
		String[] valores = data.get(0);
		String[] estados = data.get(1);
        for (int i = 0; i < valores.length; i++){
        	if (!valores[i].matches("\\d+")){
        		System.out.println("Ingreso un valor que no es numerico para la lista de valores.");
        		return false;
        	}
        }
        for (int i = 0; i < estados.length; i++){
        	if (!estados[i].matches("^[\\w,]*$")){
        		System.out.println("Ingreso un nombre con caracteres no alfanumericos.");
        		return false;
        	}
        }
        if (estados.length == valores.length || estados.length < valores.length || (estados.length - valores.length) > 1){
        	System.out.println("La cantidad de valores debe ser menor en uno a la cantidad de estados.");
    		return false;
        }
        return true;
	}
}
