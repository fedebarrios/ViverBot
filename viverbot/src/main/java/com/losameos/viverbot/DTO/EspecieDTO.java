package com.losameos.viverbot.DTO;

public class EspecieDTO {
	
	private int codEspecie;
	private String nombre;
	private String nombreCientifico;
	private String urlImage;
	
	public EspecieDTO(int codEspecie, String nombre, String nombreC, String imagen)
	{
		this.codEspecie = codEspecie;
		this.nombre = nombre; 
		this.nombreCientifico = nombreC;
		this.urlImage = imagen;
	}

	public int getCodEspecie() {
		return codEspecie;
	}

	public void setCodEspecie(int codEspecie) {
		this.codEspecie = codEspecie;
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
