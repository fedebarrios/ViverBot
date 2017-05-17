package viverbot.Modelo.WebCam;


public class AnalizadorImagen  {
	
	private static Integer valorVacio=-16777216; // imagen PNG (sin fondo)
	
	public void analizarPixel(int x, int y, Imagen imagen, Object secundario) {

		ModificadorPixel resaltar = new ModificadorPixel();
		boolean valor = compararPx(x,y,imagen,secundario); 
		if(secundario instanceof PosicionadorKernel)
			((PosicionadorKernel) secundario).posicionarKernel(x, y);
		
		resaltar.modificarPixel(x, y, imagen, secundario, valor);
		
	}

	private boolean compararPx(int x, int y, Imagen imagenResaltada, Object secundario) {
		
		imagenResaltada.getRGB(x, y);
		if( secundario instanceof Imagen){
			((Imagen) secundario).getRGB(x, y);
			return imagenResaltada.getColorImagen().getRGB()== ((Imagen) secundario).getColorImagen().getRGB();
		}
		else
			return imagenResaltada.getColorImagen().getRGB()==valorVacio;

	}
	
}
