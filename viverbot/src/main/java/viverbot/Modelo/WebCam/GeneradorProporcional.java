package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class GeneradorProporcional {
	
	public static Kernel generarKernelProporcional(Kernel kernel, float proporcion)
	{
		Integer width = kernel.getWidth();
		Integer height = kernel.getHeight();
		
		return new Kernel(width, height, aplicarProporcion(kernel, width, height,proporcion));
	}
	
	
	private static ArrayList<Integer> aplicarProporcion(Kernel kernel, Integer ancho, Integer alto, float proporcion)
	{
		ArrayList<Integer> imgProp = new ArrayList<Integer>();
	//	Integer area = (int)(Math.pow(((int)((ancho/2)*proporcion)),2)*Math.PI);
		Integer area = (int) ((ancho*proporcion)*(alto*proporcion));
	
		for(int j=0; j<area; j++)
			imgProp.add(kernel.getImagen().get(j));

		return imgProp;

	}
	

}
