package viverbot.Modelo.WebCam;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GeneradorImagen {
	
	
	public static BufferedImage generarImagen(String path)
	{
		try{ return ImageIO.read(convertirString(path)); }
		catch(Exception e) { e.printStackTrace(); }
		return null;
	}
	
	
	private static File convertirString(String ubicacion)
	{
		return new File(ubicacion);
	}

}
