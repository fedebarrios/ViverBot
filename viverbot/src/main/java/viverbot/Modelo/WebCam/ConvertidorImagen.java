package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class ConvertidorImagen {
	
	
	public ArrayList<Integer> convertirImagen(Imagen img)
	{
		ArrayList<Integer> imagen = new ArrayList<Integer>();
		for(int j=0; j<img.getAlto(); j++)
			for(int i=0; i<img.getAncho(); i++){
				img.getRGB(i, j);
					imagen.add(img.getColorImagen().getRGB()); }
		
		return imagen;
	}
	

}
