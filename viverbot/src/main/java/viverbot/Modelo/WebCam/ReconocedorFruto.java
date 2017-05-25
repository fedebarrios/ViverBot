package viverbot.Modelo.WebCam;

import java.text.DecimalFormat;

public class ReconocedorFruto {
	
	public Integer reconocerFrutos(Imagen imagen, PosicionadorKernel posicionador,float pExpectativa, float pRecibida )
	{
		Integer y=0;
		Integer x=0;
		Integer cantidadF=0;
		RectificadorImagen rectificador = new RectificadorImagen();
		DecimalFormat df = new DecimalFormat("#0.0");


		while(y != imagen.getAlto()&& y < imagen.getAlto()-posicionador.getHeightKernel()){
		while(x != imagen.getAncho() && x < imagen.getAncho()-posicionador.getWidthKernel()){				
			if(DetectorFruto.detectar(imagen, x, y, posicionador.getKernel()))
			{
				posicionador.setX(x);
				posicionador.setY(y);
				rectificador.rectificarImagen(imagen, posicionador);
				cantidadF ++;
				x += posicionador.getWidthKernel();
			}
			else
				x+=2;	
			}
			x=0;
			y ++;
		}
		
		
		if(!String.valueOf(pExpectativa).equals(df.format(pRecibida)))
		{
			System.out.println(pExpectativa+" valores "+df.format(pRecibida));
			Kernel k = GeneradorProporcional.generarKernelProporcional(posicionador.getKernel(), pRecibida-0.1f);
			posicionador.setKernel(k);
			cantidadF += reconocerFrutos(imagen, posicionador, pExpectativa, pRecibida-0.1f);
		}
		 
		return cantidadF;
		
		
	}


}
