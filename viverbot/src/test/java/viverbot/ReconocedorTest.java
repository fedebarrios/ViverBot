
package viverbot;


import javax.swing.ImageIcon;

import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.GeneradorProporcional;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.PosicionadorKernel;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.RectificadorImagen;
import viverbot.Vista.Imagen.ObtenedorSeleccionVista;

public class ReconocedorTest {
	
	public static void main(String[] args)
	{
		
		 ObtenedorSeleccionVista vista = new ObtenedorSeleccionVista();
		 ObtenedorPath obtenedor2 = new ObtenedorPath();
		 obtenedor2.obtenerPath();
		 GeneradorImagenes gen2 = new GeneradorImagenes();
		 obtenedor2.setSegundoPath("src/test/java/viverbot/recursosTest/arbolConFChicos.png");
		 gen2.generarImagenes(obtenedor2.getPrimerPath(),obtenedor2.getSegundoPath());
		 System.out.println(gen2.getSegundaImagen().getAlto());
		 AdapterImage adaptador = new AdapterImage();
		 adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objetoChico.png");
		 PosicionadorKernel posicionador = new PosicionadorKernel(0,0,adaptador);
		 
		
		 
		// System.out.println(k.getImagen().size());
		 //RectificadorImagen<PosicionadorKernel> rectificador = new RectificadorImagen<PosicionadorKernel>();
		RectificadorImagen rectificador2 = new RectificadorImagen();

		 Imagen img2 = rectificador2.rectificarImagen(gen2.getPrimerImagen(), gen2.getSegundaImagen());
	//	System.out.println("cant optenida: "+DetectorFrutos.detectar(img2, 164, 213, posicionador.getKernel()));

		 vista.getPanelPrimeraImagen().setIcon(new ImageIcon(img2.getRepresentacion()));
		 //vista.getPanelPrimeraImagen().setIcon(new ImageIcon(rectificador2.rectificarImagen(img2, posicionador).getRepresentacion()));

		 vista.visible(true);
		 ReconocedorFruto reco = new ReconocedorFruto();
		 
		 
		 GeneradorProporcional prop = new GeneradorProporcional();
	
		 System.out.println("Frutos detectados: "+reco.reconocerFrutos(img2, posicionador,0.5f,1f));

		 //    vista.getPanelPrimeraImagen().setIcon(new ImageIcon(resaltador.resaltarImagen(gen2).getRepresentacion()));
	
	}
}
