package viverbot.Modelo.WebCam;

import javax.swing.JOptionPane;

public class ValidadorImagenes {
	
	public static boolean validarTamañoImagen(String primerPath,String segundoPath)
	{
		Imagen primerImagenAux = new Imagen(primerPath);
		Imagen segundaImagenAux = new Imagen(segundoPath);
		
		if(!primerImagenAux.getAlto().equals(segundaImagenAux.getAlto()) 
				|| !primerImagenAux.getAncho().equals(segundaImagenAux.getAncho())){
			JOptionPane.showMessageDialog(null,"La resolucion de las imagenes no coinciden."); 
			return false; }
		return true;
	}
}
