package viverbot.Interfaces;

import viverbot.Modelo.WebCam.Imagen;

public interface Resaltable {
	
	public Imagen resaltar(Imagen primerImg, Object segundaImg, int x, int y);

}
