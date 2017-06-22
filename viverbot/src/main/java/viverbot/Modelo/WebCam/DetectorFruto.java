package viverbot.Modelo.WebCam;

public class DetectorFruto {
	
	public static boolean detectar(Imagen img, int x, int y, Kernel kernel)
	{
		Integer cantPx=0;
		for(int j=y; j<y+kernel.getHeight(); j++)
			for(int i=x; i<x+kernel.getWidth(); i++)
			{
				img.getRGB(i, j);
				if(validarPx(img))
					cantPx++;
			}
		
		return validarFruto(cantPx,kernel);
		
				
	}

	private static boolean validarFruto(Integer cantObtenida, Kernel kernel) {
		
		return cantObtenida.intValue()>=kernel.cantidadPixeles() && cantObtenida.intValue()<=kernel.cantidadPixeles();
	}

	private static boolean validarPx(Imagen img)
	{
		return img.getColorImagen().getRGB() != img.getRGB(0, 0);
	}

}
