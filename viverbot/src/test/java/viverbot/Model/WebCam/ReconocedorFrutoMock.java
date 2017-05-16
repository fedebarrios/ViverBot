package viverbot.Model.WebCam;

import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.PosicionadorKernel;
import viverbot.Modelo.WebCam.RectificadorImagen;

public class ReconocedorFrutoMock {
	
	public Integer reconocerFrutos(Imagen imagen, PosicionadorKernel posicionador)
	{
		Integer y=0;
		Integer x=0;
		Integer cantidadF=0;
		RectificadorImagen<PosicionadorKernel> rectificador = new RectificadorImagen<PosicionadorKernel>();

		while(y != imagen.getAlto()&& y < imagen.getAlto()-posicionador.getHeightKernel())
		{
			while(x != imagen.getAncho() && x < imagen.getAncho()-posicionador.getWidthKernel())
			{				
					if(DetectorFruto.detectar(imagen, x, y, posicionador.getKernel()))
					{
						posicionador.setX(x);
						posicionador.setY(y);
						rectificador.rectificarImagen(imagen, posicionador);
						cantidadF ++;
						x += posicionador.getWidthKernel();
					}
					else
						x ++;	
			}
			x=0;
			y ++;
		}
		return cantidadF;
		
		
	}


}
