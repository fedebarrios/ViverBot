package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class GeneradorProporcional {
	
	public static Kernel generarKernelProporcional(Kernel kernel, float proporcion)
	{
		
		Kernel newKernel = new Kernel(kernel.getWidth(),kernel.getHeight(),aplicarProporcion(kernel, kernel.getWidth(), kernel.getHeight(),proporcion));
		return newKernel;
		
	}
	
	
	private static ArrayList<Integer> aplicarProporcion(Kernel kernel, Integer ancho, Integer alto, float proporcion)
	{
		ArrayList<Integer> imgProp = new ArrayList<Integer>();
		Integer area = (int)(Math.pow(((int)((ancho/2)*proporcion)),2)*Math.PI);
		
		for(int j=0; j<area; j++){
			imgProp.add(kernel.getImagen().get(j));
		}
		//System.out.println("contador "+area+" longitud de la imagne"+ imgProp.size());
					

		return imgProp;

	}
	

}
