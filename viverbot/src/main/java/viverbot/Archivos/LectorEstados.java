package viverbot.Archivos;

public class LectorEstados extends LectorTxt {
	
	public LectorEstados() {
		super();
	}

	public void leerArchivo(String archivo){
        String data = leerTxt(archivo);
        if (data == null) return;
        if (data.indexOf('/') < 0){
        	System.out.println("Archivo no encontrado.");
        	return;
        }
        System.out.println(data);
        String valoresString = data.substring(0, data.indexOf('/'));
        String estadosString = data.substring(data.indexOf('/') + 1, data.length() - 1);
        String[] valoresNoInt = valoresString.split(",");
        String[] estados = estadosString.split(",");
        int[] valores = new int[valoresNoInt.length];
        for (int i = 0; i < valoresNoInt.length; i++){
        	if (!valoresNoInt[i].matches("\\d+")){
        		System.out.println("Ingreso un valor que no es numerico para la lista de valores.");
        		return;
        	}
        	else{
        		valores[i] = Integer.parseInt(valoresNoInt[i]);
        	}
        }
        for (int i = 0; i < estados.length; i++){
        	if (!estados[i].matches("^[\\w,]*$")){
        		System.out.println("Ingreso un nombre con caracteres no alfanumericos.");
        		return;
        	}
        }
        if (estados.length == valores.length || estados.length > valores.length || (valores.length - estados.length) > 1){
        	System.out.println("La cantidad de estados debe ser menor en uno a la cantidad de valores.");
    		return;
        }
        
        //Guardar los estados en algun lado
    }

}
