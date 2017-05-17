package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class GeneradorProporcional {
	
	public static Kernel generarKernelProporcional(Kernel kernel, float proporcion)
	{
		int anchoProp =(int)(kernel.getWidth()*proporcion);
		System.out.println(anchoProp);
		int altoProp = (int)(kernel.getHeight()*proporcion);
		Kernel newKernel = new Kernel(anchoProp,altoProp,aplicarProporcion(kernel, anchoProp, altoProp));
		return newKernel;
		
	}
	
	
	private static ArrayList<Integer> aplicarProporcion(Kernel kernel, Integer ancho, Integer alto)
	{
		ArrayList<Integer> imgProp = new ArrayList<Integer>();
		Integer area = (int)(Math.pow(((ancho/2)-2),2)*Math.PI);
		for(int j=0; j<area; j++){
			imgProp.add(kernel.getImagen().get(j));
		}
		System.out.println("contador "+area+" longitud de la imagne"+ imgProp.size());
					

		return imgProp;

	}
	

}
