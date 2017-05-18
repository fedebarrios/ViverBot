
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
		 obtenedor2.setPrimerPath("src/test/java/viverbot/recursosTest/arbol.jpg");
		 obtenedor2.setSegundoPath("src/test/java/viverbot/recursosTest/arbolConFChicos3.png");
		 gen2.generarImagenes(obtenedor2.getPrimerPath(),obtenedor2.getSegundoPath());
		 
		 
		 AdapterImage adaptador = new AdapterImage();
		 adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objetoChico.png");
		 PosicionadorKernel posicionador = new PosicionadorKernel(0,0,adaptador);
		 
		 RectificadorImagen rectificador2 = new RectificadorImagen();

		 Imagen imgResaltada = rectificador2.rectificarImagen(gen2.getPrimerImagen(), gen2.getSegundaImagen());
		// vista.getPanelPrimeraImagen().setIcon(new ImageIcon(imgResaltada.getRepresentacion()));
		 //vista.setVisible(true); 
		 
		 
		 /*
		 
		 
			*/

		
		 vista.getPanelPrimeraImagen().setIcon(new ImageIcon(rectificador2.rectificarImagen(imgResaltada, posicionador).getRepresentacion()));
		 
		 vista.visible(true);
		
		 ReconocedorFruto reco = new ReconocedorFruto();	
		 System.out.println("Frutos detectados: "+reco.reconocerFrutos(imgResaltada, posicionador,0.5f,1));
		
		 
	}
}
