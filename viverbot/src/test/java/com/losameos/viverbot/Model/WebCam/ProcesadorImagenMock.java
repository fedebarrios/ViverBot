package com.losameos.viverbot.Model.WebCam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.losameos.viverobot.Controller.WebCam.LectorImagenControlador;
import com.losameos.viverobot.Model.WebCam.ImagenPlanta;
import com.losameos.viverobot.Model.WebCam.ResaltadorImagen;
import com.losameos.viverobot.Model.WebCam.UbicacionImagen;


public class ProcesadorImagenMock {

	private ResaltadorImagen resaltadorImagen;
	private ImagenPlanta primerImagen;
	private ImagenPlanta segundaImagen;
	

	public boolean cargarImagenes(String imagen1, String imagen2) {
		
		imagenesPredeterminadas(imagen1,imagen2);
		
		if( validarTamañoImagen())
		{
			resaltadorImagen = new ResaltadorImagen(primerImagen, segundaImagen);
			return true;
		}
	
		return false;


	}
	
	private void imagenesPredeterminadas(String img1, String img2)
	{
		primerImagen = new ImagenPlanta();
		segundaImagen = new ImagenPlanta();
		primerImagen.LeerImagen(new UbicacionImagen("/Users/Pandari/Desktop/ViverBot/viverbot/src/test/java/com/losameos/viverbot/Model/WebCam/"+img1));
		segundaImagen.LeerImagen(new UbicacionImagen("/Users/Pandari/Desktop/ViverBot/viverbot/src/test/java/com/losameos/viverbot/Model/WebCam/"+img2));
	}


	private boolean validarTamañoImagen() {
		if(!primerImagen.getAlto().equals(segundaImagen.getAlto()) || !primerImagen.getAncho().equals(segundaImagen.getAncho())){
			primerImagen = null;
			segundaImagen = null;
			return false;
		}
		else
			return true;
	}

	public ImagenPlanta resaltarObjetos() {
		  resaltadorImagen.compararImagenes();
		return primerImagen;
	}

	
	public ImagenPlanta getPrimerImagen() {
		return primerImagen;
	}

	public void setPrimerImagen(ImagenPlanta primerImagen) {
		this.primerImagen = primerImagen;
	}

	public ImagenPlanta getSegundaImagen() {
		return segundaImagen;
	}

	public void setSegundaImagen(ImagenPlanta segundaImagen) {
		this.segundaImagen = segundaImagen;
	}

	
	
	

}
