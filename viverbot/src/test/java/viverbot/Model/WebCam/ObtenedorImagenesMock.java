package viverbot.Model.WebCam;

import viverbot.Controlador.Imagen.BuscadorImagenControlador;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.ValidadorImagenes;

public class ObtenedorImagenesMock {
	
	private GeneradorImagenes contenedorImagenes;

	public boolean obtenerImagenes() {
			
			//Mejorar este sector.....
			BuscadorImagenControlador buscadorImagen = new BuscadorImagenControlador();
			String segundoPath ="";
			String primerPath = buscadorImagen.buscarImagen();
			if(!primerPath.isEmpty())
				segundoPath = buscadorImagen.buscarImagen();
				if(!segundoPath.isEmpty())
				{
					if(ValidadorImagenes.validarTamañoImagen(primerPath, segundoPath)){
						contenedorImagenes = new GeneradorImagenes();
						contenedorImagenes.generarImagenes(primerPath, segundoPath);
						return true; }
					else
						return false;
				}
			else
				return false;
			
	
			//.....
		}

	public GeneradorImagenes getContenedorImagenes() {
		return contenedorImagenes;
	}

}
