package com.losameos.viverobot.VistaWebCam;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.losameos.viverobot.Controller.WebCam.BuscadorImagenControlador;

public class ObtenedorImagenVista extends JFileChooser {

	private static final long serialVersionUID = 1L;
	private String pathImagen;
	private Integer opcion;
	
	public ObtenedorImagenVista(BuscadorImagenControlador controlador) {
		
		FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
		this.setFileFilter(filtroImagen);
		this.setDialogTitle("Seleccione una imagen");
		opcion = this.showOpenDialog(null);
		
	}


	

	public String getPathImagen() {
		return pathImagen;
	}


	public Integer getOpcion() {
		return opcion;
	}

	public void setOpcion(Integer opcion) {
		this.opcion = opcion;
	}

	
	

}
