package viverbot;

import javax.swing.ImageIcon;

import viverbot.Controlador.Imagen.ObtenedorComando;
import viverbot.Modelo.WebCam.GeneradorImagenes;
import viverbot.Modelo.WebCam.ObtenedorPath;
import viverbot.Modelo.WebCam.ReconocedorFruto;
import viverbot.Modelo.WebCam.ResaltadorImagen;
import viverbot.Vista.Imagen.ObtenedorSeleccionVista;

public class recoFrutosTest {
	
	public static void main(String[] args)
	{
		 ObtenedorSeleccionVista vista = new ObtenedorSeleccionVista();
		  ResaltadorImagen resaltador = new ResaltadorImagen();
			ReconocedorFruto resalt = new ReconocedorFruto();
		  ObtenedorPath obtenedor2 = new ObtenedorPath();
		  obtenedor2.obtenerPath();
		  GeneradorImagenes gen2 = new GeneradorImagenes();
		  gen2.generarImagenes(obtenedor2.getPrimerPath(),obtenedor2.getSegundoPath());
		    vista.getPanelPrimeraImagen().setIcon(new ImageIcon(resalt.reconocerFrutos(resaltador.resaltarImagen(gen2)).getRepresentacion()));
		//    vista.getPanelPrimeraImagen().setIcon(new ImageIcon(resaltador.resaltarImagen(gen2).getRepresentacion()));

		    System.out.println("contador de frutos: "+resalt.getCont());
			  vista.visible(true);		
			  
	}
}
