package viverbot.Modelo.WebCam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ConvertidorImagen {
	
	
	public ArrayList<Integer> convertirImagen(BufferedImage img)
	{
		ArrayList<Integer> imagen = new ArrayList<Integer>();
		for(int j=0; j<img.getHeight(); j++)
			for(int i=0; i<img.getWidth(); i++){
				img.getRGB(i, j);
					imagen.add(new Color(img.getRGB(i, j)).getRGB()); }
		
		return imagen;
	}
	

}
