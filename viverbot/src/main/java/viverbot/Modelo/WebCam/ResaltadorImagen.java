package viverbot.Modelo.WebCam;

import java.awt.image.BufferedImage;

public class ResaltadorImagen {
	
	
	public static BufferedImage resaltarImagen(BufferedImage primerImagen, BufferedImage segundaImagen,int x, int y)
	{
		AnalizadorImagen analizador = new AnalizadorImagen();

		for(int j=y; j<segundaImagen.getHeight()+y; j++)
			for(int i=x; i<segundaImagen.getWidth()+x; i++){
				analizador.analizarPixel(i,j,primerImagen,segundaImagen);
			}
	
		return primerImagen;
	}
	
	

}
