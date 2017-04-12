package com.losameos.viverobot.Model.WebCam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class AtributosImagen {
	
	private BufferedImage buffer;
	private Color colorRgb;
	private Integer canalAzul;
	private Integer canalRojo;
	private Integer canalVerde;
	
	
	public void iniBuffer(File archivo) {
		try{ this.buffer = ImageIO.read(archivo); }
		catch(Exception e) { e.printStackTrace(); }

	}

	public void iniRGB(int x, int y)
	{
		this.colorRgb = new Color(buffer.getRGB(x, y));
		this.canalRojo = colorRgb.getRed();
		this.canalAzul = colorRgb.getBlue();
		this.canalVerde = colorRgb.getGreen();

	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}

	

	public Integer getCanalAzul() {
		return canalAzul;
	}

	public void setCanalAzul(Integer canalAzul) {
		this.canalAzul = canalAzul;
	}

	public Integer getCanalRojo() {
		return canalRojo;
	}

	public void setCanalRojo(Integer canalRojo) {
		this.canalRojo = canalRojo;
	}

	public Integer getCanalVerde() {
		return canalVerde;
	}

	public void setCanalVerde(Integer canalVerde) {
		this.canalVerde = canalVerde;
	}

	public Integer rgbPosicion(int x, int y) {
		return buffer.getRGB(x, y);
	}
	
	public void setValorBuffer(int x, int y, int valor)
	{
		buffer.setRGB(x, y, valor);
	}

	public Color getColorRgb() {
		return colorRgb;
	}

	public void setColorRgb(Color rgb) {
		this.colorRgb = rgb;
	}
	
	public Integer getValorRGB()
	{
		return colorRgb.getRGB();
	}

	
	
}
