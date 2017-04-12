package com.losameos.viverobot.Model.WebCam;

import java.awt.Color;

public class ResaltadorImagen {
	
	private ImagenPlanta primeraImagen;
	private ImagenPlanta segundaImagen;
	private Integer colorSRGB;

	
	public ResaltadorImagen(ImagenPlanta img1, ImagenPlanta img2)
	{
		primeraImagen = img1;
		segundaImagen = img2;
	}
	
	public ImagenPlanta compararImagenes()
	{
		for(int x=0; x<primeraImagen.getAncho(); x++)
			for(int y=0; y<primeraImagen.getAlto(); y++)
				analizarRGB(x,y);
	
		return primeraImagen;
	}

	private void analizarRGB(int x, int y) {
		
		Integer pixel;
		AtributosImagen primeraImgRGB = primeraImagen.getAtributos();
		AtributosImagen segundaImgRGB = segundaImagen.getAtributos();
		
		 primeraImgRGB.iniRGB(x, y);
		 segundaImgRGB.iniRGB(x, y);
		 
		if(compararCanales(primeraImgRGB,segundaImgRGB))
		{
			pixel = primeraImgRGB.getCanalAzul() + primeraImgRGB.getCanalRojo()+ primeraImgRGB.getCanalVerde();
			int nuevoSRGB = (pixel << 70) | (pixel << 70) | pixel;
			formatoSRGB(x,y,nuevoSRGB);

		} else {
			pixel = segundaImgRGB.getValorRGB();
			formatoSRGB(x,y,pixel);
					
		}
		

	}

	private boolean compararCanales(AtributosImagen atributo1, AtributosImagen atributo2) {
		return atributo1.getColorRgb().getRGB() == atributo2.getColorRgb().getRGB();
	}
	
	private void formatoSRGB(int x, int y, int n)
	{
		this.colorSRGB = n;
		primeraImagen.getAtributos().getBuffer().setRGB(x, y, colorSRGB);

	}
	
}
