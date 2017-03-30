package com.ViveroBot.dto;

public class EspecieDTO {
	
	private String nombre;
	private String nombreCientifico;
	private String urlImage;
	
	public EspecieDTO(String nombre, String nombreC, String imagen)
	{
		this.nombre = nombre;
		this.nombreCientifico = nombreC;
		this.urlImage = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	

}
