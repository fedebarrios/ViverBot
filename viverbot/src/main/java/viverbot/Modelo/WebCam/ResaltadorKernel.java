package viverbot.Modelo.WebCam;

public class ResaltadorKernel {
	
	public static void resaltarKernel(Imagen imagen, Kernel kernel, int x, int y)
	{
		for(int j=y; j<kernel.getHeight()+y; j++)
			for(int i=x; i<kernel.getWidth()+x; i++)
				ModificadorPixel.modificarPixel(i, j, imagen, 0);
	}

}
