package viverbot.Modelo.WebCam;

public class RectificadorImagen <T> {
	
	
	public Imagen rectificarImagen(Imagen primario, T secundario)
	{
		AnalizadorImagen<T> analizador = new AnalizadorImagen<T>();

		Integer ancho=0;
		Integer alto=0;
		Integer vX=0;
		Integer vY=0;
		
		if( secundario instanceof Imagen){
			alto = primario.getAlto();
			ancho = primario.getAncho();
		}
		else{
			alto = ((PosicionadorKernel) secundario).getHeightKernel();
			ancho = ((PosicionadorKernel) secundario).getWidthKernel();
			vX=((PosicionadorKernel) secundario).getX();
			vY=((PosicionadorKernel) secundario).getY();	
		}
		
		for(int y=vY; y<alto+vY; y++)
			for(int x=vX; x<ancho+vX; x++)
				analizador.analizarPixel(x,y,primario,secundario);
	
		return primario;
	}
	
	

}
