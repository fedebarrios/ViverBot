package viverbot.Modelo.WebCam;

import java.awt.image.BufferedImage;

public class ValidadorImagenes {
	
	public static boolean validarTamañoImagen(String primerPath,String segundoPath)
	{
		BufferedImage primerImagenAux = GeneradorImagen.generarImagen(primerPath);
		BufferedImage segundaImagenAux = GeneradorImagen.generarImagen(segundoPath);
		
		if(!(primerImagenAux.getHeight()==segundaImagenAux.getHeight()) 
				|| !(primerImagenAux.getWidth() == segundaImagenAux.getWidth())){
			return false; }
		return true;
	}
}
