
package viverbot;


import javax.swing.ImageIcon;

import viverbot.Modelo.WebCam.ComparadorKernel;
import viverbot.Modelo.WebCam.GeneradorProporcional;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.Kernel;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;

public class ReconocedorTest {
	
	public static void main(String[] args)
	{
		
		 
	 	String img1 = "src/test/java/viverbot/recursosTest/arbol.jpg";
		String img2="src/test/java/viverbot/recursosTest/arbolConFChicos.png";
		 
		 
		 
		 ComparadorKernel adaptador = new ComparadorKernel();
		 adaptador.compararKernel("src/test/java/viverbot/recursosTest/objetoChico.png",new Imagen(img1));
		 Kernel kernel = new Kernel(adaptador.getWidth(),adaptador.getHeight(),adaptador.getDatos());

		 Imagen imgResaltada =ResaltadorImagen.resaltarImagen(new Imagen(img1), new Imagen(img2),0,0);
	
		
		 ReconocedorFruto reco = new ReconocedorFruto();	
		 System.out.println("Frutos detectados: "+reco.reconocerFrutos(imgResaltada, kernel,0.5f,1));
		
		 
	}
}
