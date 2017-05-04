package viverobot.Model.WebCam;

import viverobot.Controller.WebCam.BuscadorImagenControlador;

public class ObtenedorImagenes {

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
