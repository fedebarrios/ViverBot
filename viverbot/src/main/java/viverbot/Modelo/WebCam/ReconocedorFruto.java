package viverbot.Modelo.WebCam;

import java.text.DecimalFormat;

public class ReconocedorFruto {
	
	public Integer reconocerFrutos(Imagen imagen, Kernel kernel,float pExpectativa, float pRecibida )
	{
		Integer y=0;
		Integer x=0;
		Integer cantidadF=0;
		DecimalFormat formatoD = new DecimalFormat("#0.0");

		while(y != imagen.getAlto()&& y < imagen.getAlto()-kernel.getHeight()){
		while(x != imagen.getAncho() && x < imagen.getAncho()-kernel.getWidth()){				
			if(DetectorFruto.detectar(imagen, x, y, kernel))
			{
				ResaltadorKernel.resaltarKernel(imagen, kernel,x,y);
				cantidadF ++;
				x += kernel.getWidth();
			}
			else
				x+=2;	
			}
			x=0;
			y ++;
		}
		
		
		if(!String.valueOf(pExpectativa).equals(formatoD.format(pRecibida)))
		{
			System.out.println(pExpectativa+" valores "+formatoD.format(pRecibida));
			Kernel nuevoKernel = GeneradorProporcional.generarKernelProporcional(kernel, pRecibida-0.1f);
			cantidadF += reconocerFrutos(imagen, nuevoKernel, pExpectativa, pRecibida-0.1f);
		}
		 
		return cantidadF;
		
		
	}


}
