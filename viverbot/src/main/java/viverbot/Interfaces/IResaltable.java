package viverbot.Interfaces;

import viverbot.Modelo.WebCam.Imagen;

public interface IResaltable {
	
	public void resaltarPixel(int x, int y,Imagen imagenResaltada, Object imagenBoseto, boolean result);

}
