package viverobot.Controller.WebCam;


import viverobot.Model.WebCam.ValidadorSeleccion;
import viverobot.VistaWebCam.ObtenedorImagenVista;

public class BuscadorImagenControlador {
	
	public String buscarImagen()
	{
		ObtenedorImagenVista obtenedorImagenVista = new ObtenedorImagenVista(this);
		String pathImagen="";
		
		if(ValidadorSeleccion.validarOpcion(obtenedorImagenVista.getOpcion()))
		{
			try { 
				if(ValidadorSeleccion.validarExtencion(obtenedorImagenVista.getSelectedFile().getPath())){
					pathImagen = obtenedorImagenVista.getSelectedFile().getPath();
					return pathImagen;
				}
				else
					return buscarImagen();
			}
				
			catch (Exception e){ e.printStackTrace(); }
		}
		
		return pathImagen;
	}
		
	
}
