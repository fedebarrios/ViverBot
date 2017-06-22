package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class ComparadorKernel {
	
	private ArrayList<Integer> datos;
	private Integer width;
	private Integer height;
	
	public boolean compararKernel(String path,Imagen imagen)
	{
				
		Imagen img = new Imagen(path);
		ValidadorKernel validador = new ValidadorKernel();
		ConvertidorImagen convertidor = new ConvertidorImagen();
		try{ if(validador.validarKernel(img,imagen)){
				datos = convertidor.convertirImagen(img);
				width = img.getAncho();
				height = img.getAlto();
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
