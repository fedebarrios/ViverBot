package viverbot.Modelo.WebCam;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class DetectorFruto {
	
	public static boolean detectar(BufferedImage img, int x, int y, Kernel kernel)
	{
		Integer cantPx=0;
		for(int j=y; j<y+kernel.getHeight(); j++)
			for(int i=x; i<x+kernel.getWidth(); i++)
			{
				//img.getRGB(i, j);
				if(validarPx(img,i,j))
					cantPx++;
			}
		
		return validarFruto(cantPx,kernel);
		
				
	}

	private static boolean validarFruto(Integer cantObtenida, Kernel kernel) {
		
		return cantObtenida.intValue()>=kernel.cantidadPixeles() && cantObtenida.intValue()<=kernel.cantidadPixeles();
	}

	private static boolean validarPx(BufferedImage img, int x, int y)
	{
		return new Color(img.getRGB(x, y)).getRGB() != new Color(img.getRGB(0, 0)).getRGB();
	}

}
