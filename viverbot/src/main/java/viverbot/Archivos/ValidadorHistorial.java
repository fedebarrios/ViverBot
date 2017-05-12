package viverbot.Archivos;

import java.util.List;

import viverbot.Controlador.Verificacion.Verificador;

public class ValidadorHistorial {
	
	public ValidadorHistorial(){
		
	}
	
	public boolean validarDatosNumericosHistorial(String[] datos){
		if( Verificador.campoExclusivamenteNumerico(datos[0]) && Verificador.campoExclusivamenteNumerico(datos[1])){
			return true;
		}
		return false;
	}

	public boolean validarCantidadDatosHistorial(String[] datos) {
		if (datos.length == 2) return true;
		//else if (datos[0].substring(0, 1).equals("e")&& datos.length == 3) return true;
		return false;
	}
	
	protected boolean validarHistorial(List<String> entradas){
		int pos = 0;
		for (String s : entradas){
			
			if(pos+1 != entradas.size()){

				String[] datos = Separador.separarDato(s);
				datos[0] = datos[0].substring(1);
				System.out.println(datos[0]+".."+datos[1]);
				if (!validarDatosNumericosHistorial(datos)){
					System.out.println("No se puede ingresar informacion que no sean numeros");
					return false;
				} else if(!validarCantidadDatosHistorial(datos)){
					System.out.println("Debe ingresar dos datos por fila");	
					return false;
				}
				
			}
			pos++;
		}
		return true;
	}
}
