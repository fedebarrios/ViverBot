package viverbot.Modelo.WebCam;

import java.awt.image.BufferedImage;

public class ValidadorImagenes {
	
	public static boolean validarTamañoImagen(BufferedImage primerImagen,BufferedImage segundaImagen)
	{
		if(!(primerImagen.getHeight()==segundaImagen.getHeight()) 
				|| !(primerImagen.getWidth() == segundaImagen.getWidth())){
			return false; }
		return true;
	}
}
