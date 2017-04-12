package com.losameos.viverobot.Model.WebCam;

import javax.swing.JOptionPane;

public class ImagenPlanta {
	
	private Integer ancho;
	private Integer alto;
	private AtributosImagen atributos;
	

	public ImagenPlanta LeerImagen(UbicacionImagen archivo)
	{
		atributos = new AtributosImagen();
		atributos.iniBuffer(archivo.generarArchivo());
		ancho = atributos.getBuffer().getWidth();
		alto = atributos.getBuffer().getHeight();
			
		return this;
	}
	
	public Integer getRgb(int x, int y) {
		return atributos.rgbPosicion(x, y);
	}


	public AtributosImagen getAtributos() {
		return atributos;
	}

	public void setAtributos(AtributosImagen atributos) {
		this.atributos = atributos;
	}

	public Integer getAncho() {
		return ancho;
	}


	public Integer getAlto() {
		return alto;
	}



	

}
