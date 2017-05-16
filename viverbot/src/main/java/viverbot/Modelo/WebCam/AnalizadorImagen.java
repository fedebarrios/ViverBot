package viverbot.Modelo.WebCam;


public class AnalizadorImagen <T> {
	
	public void analizarPixel(int x, int y, Imagen imagen, T secundario) {


		ResaltadorPixel resaltar = new ResaltadorPixel();
		boolean valor = compararPx(x,y,imagen,secundario); 

		if(secundario instanceof PosicionadorKernel){
			((PosicionadorKernel) secundario).posicionarKernel(x, y);
		}
		
		resaltar.resaltarPixel(x, y, imagen, secundario, valor);


		
	}

	private boolean compararPx(int x, int y, Imagen imagenResaltada, T secundario) {
		
		imagenResaltada.getRGB(x, y);

		if( secundario instanceof Imagen){
			((Imagen) secundario).getRGB(x, y);
			return imagenResaltada.getColorImagen().getRGB()== ((Imagen) secundario).getColorImagen().getRGB();
		}
		else
			return imagenResaltada.getColorImagen().getRGB()==-16777216;

	}
	
}
