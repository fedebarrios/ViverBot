package viverbot.Modelo.WebCam;

import java.util.ArrayList;

public class Kernel {
	
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;
	private ArrayList<Integer> datos;
	
	public Kernel()
	{
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.datos = new ArrayList<Integer>();
	}
	
	public Kernel(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 33+x;
		this.height = 27+y;
		this.datos = new ArrayList<Integer>();
	}

	
	public Integer iesimo(int n)
	{
		return datos.get(n);
	}
	
	public void addPx(int n)
	{
		datos.add(n);
	}

	public Integer getWidth() {
		return width;
	}


	public void setWidth(Integer width) {
		this.width = width;
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
	}

	public ArrayList<Integer> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<Integer> datos) {
		this.datos = datos;
	}
	
	public Integer cantidadPixel()
	{
		return datos.size();
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}





	
}
