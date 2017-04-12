package com.losameos.viverobot.Model.WebCam;

import java.io.File;

public class UbicacionImagen {
	
	private String ubicacion;
	
	public UbicacionImagen(String ubicacion)
	{
		this.ubicacion = ubicacion;
	}
	
	public File generarArchivo()
	{
		return new File(ubicacion);
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
