package viverbot.Modelo.WebCam;

import java.awt.image.BufferedImage;

public class ModificadorPixel {
	
	public static void modificarPixel(int x, int y, BufferedImage imagen, Integer rgb) {
		imagen.setRGB(x, y, rgb);
	}

}
