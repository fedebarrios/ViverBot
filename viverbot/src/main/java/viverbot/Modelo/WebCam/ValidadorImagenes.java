package viverbot.Modelo.WebCam;


public class ValidadorImagenes {
	
	public static boolean validarTamañoImagen(String primerPath,String segundoPath)
	{
		Imagen primerImagenAux = new Imagen(primerPath);
		Imagen segundaImagenAux = new Imagen(segundoPath);
		
		if(!primerImagenAux.getAlto().equals(segundaImagenAux.getAlto()) 
				|| !primerImagenAux.getAncho().equals(segundaImagenAux.getAncho())){
			return false; }
		return true;
	}
}
