package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class AdapterImage {
	
	private ArrayList<Integer> datos;
	private Integer width;
	private Integer height;
	
	public boolean adaptarImagen(String path)
	{
		Imagen img = new Imagen(path);
		ValidadorKernel validador = new ValidadorKernel();
		ConvertidorImagen convertidor = new ConvertidorImagen();
		if(validador.validarKernel(img)){
			datos = convertidor.convertirImagen(img);
			width = img.getAncho();
			height = img.getAlto();
			return true;}
		else
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
