package viverbot.Modelo.WebCam;

public class ModificadorPixel {
	
	public static void modificarPixel(int x, int y, Imagen imagen, Integer rgb) {
		imagen.setRGB(x, y, rgb);
	}

}
