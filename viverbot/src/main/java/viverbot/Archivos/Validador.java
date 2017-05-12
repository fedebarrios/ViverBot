package viverbot.Archivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import viverbot.Controlador.Verificacion.Verificador;

public class Validador {
	
	public Validador(){
		
	}
	
	public boolean validarDatosNumericosHistorial(String[] datos){
		if( Verificador.campoExclusivamenteNumerico(datos[0]) && Verificador.campoExclusivamenteNumerico(datos[1])){
			return true;
		}
		return false;
	}

	public boolean validarCantidadDatosHistorial(String[] datos) {
		if (datos.length == 2) return true;
		return false;
	}
	
	/*protected boolean validarDatosHistorial(List<String> entradas){
		List<double[]> listaDatos = new ArrayList<double[]>();
		for (String s : entradas){
			String[] datos = parser.separarDato(s);
			if (!validador.validarDatosNumericosHistorial(datos)){
				System.out.println("No se puede ingresar informacion que no sean numeros");
			} else if(!validador.validarCantidadDatosHistorial(datos)){
				System.out.println("Debe ingresar dos datos por fila");	
			}
			else{
				double dia = Double.parseDouble(datos[0]);
				double altura = Double.parseDouble(datos[1]);
				double[] tupla = { dia , altura };
				listaDatos.add(tupla);
			}
		}
		return listaDatos;
	}*/
}
