
package viverbot;


import javax.swing.ImageIcon;

import viverbot.Modelo.WebCam.AdapterImage;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.GeneradorProporcional;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;
import viverbot.Vista.Imagen.ObtenedorSeleccionVista;

public class ReconocedorTest {
	
	public static void main(String[] args)
	{
		
		 ObtenedorSeleccionVista vista = new ObtenedorSeleccionVista();
		 
		 ObtenedorPath obtenedor2 = new ObtenedorPath();
		 obtenedor2.obtenerPath();
		 GeneradorImagenes gen2 = new GeneradorImagenes();
		 obtenedor2.setPrimerPath("src/test/java/viverbot/recursosTest/arbol.jpg");
		 obtenedor2.setSegundoPath("src/test/java/viverbot/recursosTest/arbolConFChicos.png");
		 gen2.generarImagenes(obtenedor2.getPrimerPath(),obtenedor2.getSegundoPath());
		 
		 
		 
		 AdapterImage adaptador = new AdapterImage();
		 adaptador.adaptarImagen("src/test/java/viverbot/recursosTest/objetoChico.png");
		 Kernel kernel = new Kernel(adaptador.getWidth(),adaptador.getHeight(),adaptador.getDatos());

		 ResaltadorImagen.resaltarImagen(gen2.getPrimerImagen(), gen2.getSegundaImagen(),0,0);
		 Imagen imgResaltada = gen2.getPrimerImagen();
		 vista.getPanelPrimeraImagen().setIcon(new ImageIcon(imgResaltada.getRepresentacion()));
		 vista.visible(true);
		
		 ReconocedorFruto reco = new ReconocedorFruto();	
		 System.out.println("Frutos detectados: "+reco.reconocerFrutos(imgResaltada, kernel,0.5f,1));
		
		 
	}
}
