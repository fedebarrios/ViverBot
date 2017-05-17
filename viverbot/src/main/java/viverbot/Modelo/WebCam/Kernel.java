package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class Kernel {
	
	private Integer width;
	private Integer height;
	private ArrayList<Integer> imagen;
	
	
	public Kernel(int ancho, int alto, ArrayList<Integer> datos)
	{
	
		this.width = ancho;
		this.height = alto;
		this.imagen = datos;
	}
	
	public ArrayList<Integer> getImagen()
	{
		return imagen;
	}


	public Integer getWidth() {
		return width;
	}



	public Integer getHeight() {
		return height;
	}


	public Integer cantidadPixeles()
	{
		return imagen.size();
	}




	
}
