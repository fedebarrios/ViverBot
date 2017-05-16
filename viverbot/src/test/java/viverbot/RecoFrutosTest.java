
package viverbot;

import javax.swing.ImageIcon;

import viverbot.Controlador.Imagen.ObtenedorComando;
import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.DetectorFruto;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.PosicionadorKernel;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.RectificadorImagen;
import viverbot.Vista.Imagen.ObtenedorSeleccionVista;

public class RecoFrutosTest {
	
	public static void main(String[] args)
	{
		/*
		 ObtenedorSeleccionVista vista = new ObtenedorSeleccionVista();
		 ResaltadorImagen resaltador = new ResaltadorImagen();
		 ReconocedorFruto resalt = new ReconocedorFruto();
		 ObtenedorPath obtenedor2 = new ObtenedorPath();
		 obtenedor2.obtenerPath();
		 GeneradorImagenes gen2 = new GeneradorImagenes();
		 obtenedor2.setSegundoPath("src/test/java/viverbot/recursosTest/arbolObjeto.png");
		 gen2.generarImagenes(obtenedor2.getPrimerPath(),obtenedor2.getSegundoPath());
		 vista.getPanelPrimeraImagen().setIcon(new ImageIcon(resalt.reconocerFrutos(resaltador.resaltarImagen(gen2)).getRepresentacion()));
		//    vista.getPanelPrimeraImagen().setIcon(new ImageIcon(resaltador.resaltarImagen(gen2).getRepresentacion()));

		    System.out.println("contador de frutos: "+resalt.getCont());
			  vista.visible(true);	
			  
		
		AdapterImage adaptador = new AdapterImage();
		adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objetoChico.png");
		PosicionadorKernel posicionador = new PosicionadorKernel(adaptador);
		System.out.println("ancho del kernel: "+posicionador.getWidthKernel()+" alto del kernel: "+posicionador.getHeightKernel()+
					" cantidad de pixeles: "+ posicionador.getKernel().cantidadPixel());
		
		*/
		 ObtenedorSeleccionVista vista = new ObtenedorSeleccionVista();
		 ObtenedorPath obtenedor2 = new ObtenedorPath();
		 obtenedor2.obtenerPath();
		 GeneradorImagenes gen2 = new GeneradorImagenes();
		 obtenedor2.setSegundoPath("src/test/java/viverbot/recursosTest/arbol15.png");
		 gen2.generarImagenes(obtenedor2.getPrimerPath(),obtenedor2.getSegundoPath());
		
		 AdapterImage adaptador = new AdapterImage();
		adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objetoChico.png");
		PosicionadorKernel posicionador = new PosicionadorKernel(0,0,adaptador);
		 //RectificadorImagen<PosicionadorKernel> rectificador = new RectificadorImagen<PosicionadorKernel>();
		 RectificadorImagen<Imagen> rectificador2 = new RectificadorImagen<Imagen>();

		 Imagen img2 = rectificador2.rectificarImagen(gen2.getPrimerImagen(), gen2.getSegundaImagen());
	//	System.out.println("cant optenida: "+DetectorFrutos.detectar(img2, 164, 213, posicionador.getKernel()));

		 vista.getPanelPrimeraImagen().setIcon(new ImageIcon(img2.getRepresentacion()));
		 //vista.getPanelPrimeraImagen().setIcon(new ImageIcon(rectificador2.rectificarImagen(img2, posicionador).getRepresentacion()));

		 vista.visible(true);
		 ReconocedorFruto reco = new ReconocedorFruto();
		 System.out.println("Cantidad de frutos: "+reco.reconocerFrutos(img2, posicionador));
		
		 //    vista.getPanelPrimeraImagen().setIcon(new ImageIcon(resaltador.resaltarImagen(gen2).getRepresentacion()));
		
	}
}
