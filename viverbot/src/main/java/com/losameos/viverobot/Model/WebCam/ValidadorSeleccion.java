package com.losameos.viverobot.Model.WebCam;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.losameos.viverbot.Controller.Verificacion.Verificador;
import com.losameos.viverobot.VistaWebCam.ObtenedorImagenVista;

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
