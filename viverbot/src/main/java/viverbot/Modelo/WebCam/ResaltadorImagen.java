package viverbot.Modelo.WebCam;


public class ResaltadorImagen {
	
	
	public Imagen resaltarImagen(GeneradorImagenes contenedor)
	{
		
		Imagen imagenResaltada = contenedor.getPrimerImagen();
		Imagen imagenBoseto = contenedor.getSegundaImagen();
		for(int x=0; x<imagenResaltada.getAncho(); x++)
			for(int y=0; y<imagenResaltada.getAlto(); y++)
				analizarRGB(x,y,imagenResaltada,imagenBoseto);
	
		return imagenResaltada;
	}

	private void analizarRGB(int x, int y, Imagen imagenResaltada, Imagen imagenBoseto) {
		
		Integer pixel;
		
		imagenResaltada.getRGB(x, y);
		imagenBoseto.getRGB(x, y);

		if(compararCanales(imagenResaltada,imagenBoseto)) pixel = 0;
		else pixel = imagenBoseto.valorRGB();
			
		formatoSRGB(x,y,pixel, imagenResaltada, imagenBoseto);
		
	}
	
	private boolean compararCanales(Imagen imagenResaltada, Imagen imagenBoseto) {
		return imagenResaltada.getColorImagen().getRGB()== imagenBoseto.getColorImagen().getRGB();
	}
	
	private void formatoSRGB(int x, int y, int n,Imagen imagenResaltada, Imagen imagenBoseto)
	{
		imagenResaltada.setRGB(x, y, n);

	}
	
}
