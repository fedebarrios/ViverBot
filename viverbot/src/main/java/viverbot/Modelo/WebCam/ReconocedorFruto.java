package viverbot.Modelo.WebCam;


public class ReconocedorFruto {
	
	public Integer reconocerFrutos(Imagen imagen, PosicionadorKernel posicionador)
	{
		Integer y=0;
		Integer x=0;
		Integer cantidadF=0;
		RectificadorImagen<PosicionadorKernel> rectificador = new RectificadorImagen<PosicionadorKernel>();

		while(y != imagen.getAlto()&& y < imagen.getAlto()-33)
		{
			while(x != imagen.getAncho() && x < imagen.getAncho()-33)
			{				
					if(DetectorFruto.detectar(imagen, x, y, posicionador.getKernel()))
					{
						posicionador.setX(x);
						posicionador.setY(y);
						rectificador.rectificarImagen(imagen, posicionador);
						cantidadF ++;
						x += 33;
					}
					else
						{
							x += 1;
						}
			}
			x=0;
			y += 1;
		}
		return cantidadF;
		
		
	}


}
