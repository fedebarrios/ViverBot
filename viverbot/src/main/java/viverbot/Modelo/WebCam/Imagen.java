package viverbot.Modelo.WebCam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Imagen {

	private BufferedImage representacion;
	private Color colorImagen;
	
	public Imagen(String path)
	{
		try{ this.representacion = ImageIO.read(convertirString(path)); }
		catch(Exception e) { e.printStackTrace(); }

	}
	
	public Integer getRGB(int x, int y)
	{
		
		colorImagen = new Color(representacion.getRGB(x, y));
		return colorImagen.getRGB();
	}
	
	public Integer valorRGB()
	{
		return colorImagen.getRGB();
	}
	
	public void setRGB(int x, int y, int n)
	{
		representacion.setRGB(x, y, n);
	}
	
	
	public Integer getAncho()
	{
		return representacion.getWidth();
	}
	
	public Integer getAlto()
	{
		return representacion.getHeight();
	}

	public BufferedImage getRepresentacion() {
		return representacion;
	}


	public Color getColorImagen() {
		return colorImagen;
	}

	
	private static File convertirString(String ubicacion)
	{
		return new File(ubicacion);
	}

	

}
