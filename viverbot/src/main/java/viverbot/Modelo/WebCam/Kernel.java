package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class Kernel {
	
	private Integer width;
	private Integer height;
	private ArrayList<Integer> datos;
	
	
	public Kernel(int x, int y, ArrayList<Integer> datos)
	{
	
		this.width = x;
		this.height = y;
		this.datos = datos;
	}


	public Integer getWidth() {
		return width;
	}



	public Integer getHeight() {
		return height;
	}


	public Integer cantidadPixeles()
	{
		return datos.size();
	}




	
}
