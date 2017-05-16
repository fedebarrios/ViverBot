package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class ConvertidorImagen {
	
	private static Integer valorVacio=-16777216; // imagen PNG (sin fondo)
	
	public ArrayList<Integer> convertirImagen(Imagen img)
	{
		ArrayList<Integer> datos = new ArrayList<Integer>();
		for(int j=0; j<img.getAlto(); j++)
			for(int i=0; i<img.getAncho(); i++){
				img.getRGB(i, j);
				if(img.getColorImagen().getRGB()!=valorVacio)
					datos.add(img.getColorImagen().getRGB()); }
		
		return datos;
	}
	

}
