package viverbot.Model.WebCam;

import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ResaltadorImagen;
import viverbot.Modelo.WebCam.ResaltadorKernel;

public class ReconocedorFrutoMock {
	
	public Integer reconocerFrutos(Imagen imagen, Kernel kernel,int x, int y)
	{

		Integer cantidadF=0;

	
		if(DetectorFruto.detectar(imagen, x, y, kernel))
		{
		
			ResaltadorKernel.resaltarKernel(imagen, kernel,x,y);
			cantidadF ++;
			x = kernel.getWidth();
		}
		else
			x ++;	
			
	
		return x;
		
		
	}


}
