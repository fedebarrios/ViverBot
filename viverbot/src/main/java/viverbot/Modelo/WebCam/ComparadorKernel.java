package viverbot.Modelo.WebCam;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ComparadorKernel {
	
	private ArrayList<Integer> datos;
	private Integer width;
	private Integer height;
	
	public boolean compararKernel(String path,BufferedImage imagen)
	{
				
		BufferedImage img = GeneradorImagen.generarImagen(path);
		ValidadorKernel validador = new ValidadorKernel();
		ConvertidorImagen convertidor = new ConvertidorImagen();
		try{ if(validador.validarKernel(img,imagen)){
				datos = convertidor.convertirImagen(img);
				width = img.getWidth();
				height = img.getHeight();
				return true;}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

		
	}
	
	public Integer getCantidadPixeles()
	{
		return datos.size();
	}

	public ArrayList<Integer> getDatos() {
		return datos;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}
	
	

}
