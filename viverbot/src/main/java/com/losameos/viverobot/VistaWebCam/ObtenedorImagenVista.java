package com.losameos.viverobot.VistaWebCam;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.losameos.viverobot.Controller.WebCam.LectorImagenControlador;
import com.losameos.viverobot.Model.WebCam.UbicacionImagen;

public class ObtenedorImagenVista extends JFileChooser {

	private static final long serialVersionUID = 1L;
	private UbicacionImagen directorioImagen;
	
	public ObtenedorImagenVista(LectorImagenControlador controlador) {
		
		FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
		this.setFileFilter(filtroImagen);
		this.setDialogTitle("Seleccione una imagen");

		int opcion = this.showOpenDialog(null);

		if (opcion == JFileChooser.APPROVE_OPTION) 
		{
			try { directorioImagen = new UbicacionImagen(this.getSelectedFile().getPath()); }
			catch (Exception e){ e.printStackTrace(); }
		}
		
	}

	public UbicacionImagen getDirectorioImagen() {
		return directorioImagen;
	}

	public void setDirectorioImagen(UbicacionImagen directorioImagen) {
		this.directorioImagen = directorioImagen;
	}

	
	

}
