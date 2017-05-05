package viverbot.Controlador.Imagen;


import viverbot.Model.WebCam.ValidadorSeleccion;
import viverbot.Vista.Imagen.ObtenedorImagenVista;

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
