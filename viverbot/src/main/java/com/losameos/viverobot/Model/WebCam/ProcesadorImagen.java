package com.losameos.viverobot.Model.WebCam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.losameos.viverobot.Controller.WebCam.LectorImagenControlador;


public class ProcesadorImagen {

	private LectorImagenControlador lectorImagen;
	private ResaltadorImagen resaltadorImagen;
	private ImagenPlanta primerImagen;
	private ImagenPlanta segundaImagen;
	

	public boolean cargarImagenes() {
		
		lectorImagen = new LectorImagenControlador();
		
		if(validarImagenElegida() && validarTamañoImagen())
		{
			resaltadorImagen = new ResaltadorImagen(primerImagen, segundaImagen);
			return true;
		}
	
		return false;


	}
	
	private boolean validarImagenElegida()
	{
		primerImagen = lectorImagen.accederImagen();
		if(primerImagen != null)
			segundaImagen = lectorImagen.accederImagen();
			if(segundaImagen != null)
				return true;
		return false;
	}

	private boolean validarTamañoImagen() {
		if(!primerImagen.getAlto().equals(segundaImagen.getAlto()) || !primerImagen.getAncho().equals(segundaImagen.getAncho())){
			primerImagen = null;
			segundaImagen = null;
			JOptionPane.showMessageDialog(null,"La resolucion de las imagenes no coinciden."); 
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

	public LectorImagenControlador getLectorImagen() {
		return lectorImagen;
	}

	public void setLectorImagen(LectorImagenControlador lectorImagen) {
		this.lectorImagen = lectorImagen;
	}
	
	

}
