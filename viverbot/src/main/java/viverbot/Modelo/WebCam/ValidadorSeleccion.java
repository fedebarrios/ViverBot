package viverbot.Modelo.WebCam;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import viverbot.Controlador.Verificacion.Verificador;
import viverobot.Vista.WebCam.ObtenedorImagenVista;

public class ValidadorSeleccion {
	
	
	public static boolean validarOpcion(Integer opcion)
	{
		if (opcion == JFileChooser.APPROVE_OPTION) return true;
		else return false;
	
	}
	
	public static boolean validarExtencion(String path)
	{
		if(Verificador.extensionImagenValida(path)) return true;
		else{ JOptionPane.showMessageDialog(null,"La extencion del archivo elegido no es valida.");	
			  return false; }
			
	}
	
	public static boolean validarPathSeleccionado(String primerPath) {
		return primerPath.isEmpty();
	}
	
}
