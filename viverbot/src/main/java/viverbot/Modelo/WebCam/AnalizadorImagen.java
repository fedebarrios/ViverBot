package viverbot.Modelo.WebCam;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class AnalizadorImagen  {

	public void analizarPixel(int x, int y, BufferedImage primerImagen, BufferedImage segundaImagen) {

		if(!compararPx(x,y,primerImagen,segundaImagen)){
			Integer rgb = new Color(segundaImagen.getRGB(x, y)).getRGB();
			ModificadorPixel.modificarPixel(x, y, primerImagen, rgb);
		}
		else
			ModificadorPixel.modificarPixel(x, y, primerImagen, 0);
		
	}

	private boolean compararPx(int x, int y, BufferedImage primerImagen, BufferedImage segundaImagen) {
	
		primerImagen.getRGB(x, y);
		segundaImagen.getRGB(x, y);
		return new Color(primerImagen.getRGB(x, y)).getRGB() == new Color(segundaImagen.getRGB(x, y)).getRGB();


	}
	
}
