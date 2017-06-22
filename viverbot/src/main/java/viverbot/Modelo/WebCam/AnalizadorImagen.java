package viverbot.Modelo.WebCam;


public class AnalizadorImagen  {
	
	public void analizarPixel(int x, int y, Imagen primerImagen, Imagen segundaImagen) {

		if(!compararPx(x,y,primerImagen,segundaImagen)){
			Integer rgb = segundaImagen.valorRGB();
			ModificadorPixel.modificarPixel(x, y, primerImagen, rgb);
		}
		else
			ModificadorPixel.modificarPixel(x, y, primerImagen, 0);
		
	}

	private boolean compararPx(int x, int y, Imagen primerImagen, Imagen segundaImagen) {
	
		primerImagen.getRGB(x, y);
		segundaImagen.getRGB(x, y);
		return primerImagen.getColorImagen().getRGB() == segundaImagen.getColorImagen().getRGB();


	}
	
}
