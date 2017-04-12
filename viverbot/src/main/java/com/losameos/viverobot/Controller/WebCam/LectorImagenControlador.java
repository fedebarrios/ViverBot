package com.losameos.viverobot.Controller.WebCam;


import javax.swing.JOptionPane;

import com.losameos.viverbot.Controller.Verificacion.Verificador;
import com.losameos.viverobot.Model.WebCam.ImagenPlanta;
import com.losameos.viverobot.VistaWebCam.ObtenedorImagenVista;

public class LectorImagenControlador {
	
	public ImagenPlanta accederImagen()
	{
		ObtenedorImagenVista obtenedorImagenVista = new ObtenedorImagenVista(this);
		if(obtenedorImagenVista.getDirectorioImagen() == null) {
			JOptionPane.showMessageDialog(null,"Vuelva a cargar la imagen.");
			return null;
		}
		else
		{
			String ubicacionImagen = obtenedorImagenVista.getDirectorioImagen().getUbicacion();
			if(validarExtencion(ubicacionImagen))
				return new ImagenPlanta().LeerImagen(obtenedorImagenVista.getDirectorioImagen());
			else
				JOptionPane.showMessageDialog(null,"La extencion del archivo elegido no es valida.");
			return null;

		}
	}

	private boolean validarExtencion(String ubicacion)
	{
		Verificador verificador = new Verificador();
		return verificador.extensionImagenValida(ubicacion);
	}
}
