package viverbot.Modelo.WebCam;

public class ModificadorPixel {
	
	public void modificarPixel(int x, int y, Imagen imagen, Object dato, boolean result) {
		
		Integer rgb=0;
		if(dato instanceof Imagen)
			if(!result) rgb=((Imagen) dato).valorRGB();
		
		imagen.setRGB(x, y, rgb);
		
	}

}
