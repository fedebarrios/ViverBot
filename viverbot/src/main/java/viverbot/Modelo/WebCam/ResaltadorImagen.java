package viverbot.Modelo.WebCam;

public class ResaltadorImagen {
	
	
	public static Imagen resaltarImagen(Imagen primerImagen, Imagen segundaImagen,int x, int y)
	{
		AnalizadorImagen analizador = new AnalizadorImagen();

		for(int j=y; j<segundaImagen.getAlto()+y; j++)
			for(int i=x; i<segundaImagen.getAncho()+x; i++){
				analizador.analizarPixel(i,j,primerImagen,segundaImagen);
			}
	
		return primerImagen;
	}
	
	

}
