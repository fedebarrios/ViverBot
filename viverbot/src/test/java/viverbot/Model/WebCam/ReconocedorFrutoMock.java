package viverbot.Model.WebCam;

import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.PosicionadorKernel;
import viverbot.Modelo.WebCam.RectificadorImagen;

public class ReconocedorFrutoMock {
	
	public Integer reconocerFrutos(Imagen imagen, PosicionadorKernel posicionador)
	{
		Integer y=posicionador.getY();
		Integer x=posicionador.getX();
		Integer cantidadF=0;
		RectificadorImagen rectificador = new RectificadorImagen();

	
		if(DetectorFruto.detectar(imagen, x, y, posicionador.getKernel()))
		{
			posicionador.setX(x);
			posicionador.setY(y);
			rectificador.rectificarImagen(imagen, posicionador);
			cantidadF ++;
			x = posicionador.getWidthKernel();
		}
		else
			x ++;	
			
	
		return x;
		
		
	}


}
