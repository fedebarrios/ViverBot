package viverbot.Modelo.WebCam;


public class ReconocedorFruto {
	
	public Integer reconocerFrutos(Imagen imagen, PosicionadorKernel posicionador)
	{
		Integer y=0;
		Integer x=0;
		Integer cantidadF=0;
		RectificadorImagen rectificador = new RectificadorImagen();

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
