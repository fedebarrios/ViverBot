package com.losameos.viverobot.Controller.WebCam;


import javax.swing.JOptionPane;

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
			return new ImagenPlanta().LeerImagen(obtenedorImagenVista.getDirectorioImagen());
	}


}
