package viverbot.Modelo.WebCam;


public class AnalizadorImagen  {
	
	
	public void analizarPixel(int x, int y, Imagen imagen, Object secundario) {

		ModificadorPixel resaltar = new ModificadorPixel();
		boolean valor = false;
		if(secundario instanceof PosicionadorKernel)
			((PosicionadorKernel) secundario).posicionarKernel(x, y);
		else
			valor = compararPx(x,y,imagen,secundario); 
		
		resaltar.modificarPixel(x, y, imagen, secundario, valor);
		
	}

	private boolean compararPx(int x, int y, Imagen imagenResaltada, Object secundario) {
		
		imagenResaltada.getRGB(x, y);
		if( secundario instanceof Imagen){
			((Imagen) secundario).getRGB(x, y);
			return imagenResaltada.getColorImagen().getRGB()==((Imagen) secundario).getColorImagen().getRGB();
		}
		return true;

	}
	
}
