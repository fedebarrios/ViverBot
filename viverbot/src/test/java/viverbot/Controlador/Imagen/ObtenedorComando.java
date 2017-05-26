package viverbot.Controlador.Imagen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import viverbot.Model.WebCam.ObtenedorImagenesMock;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.ResaltadorImagen;
import viverbot.Vista.Imagen.ObtenedorSeleccionVista;


public class ObtenedorComando implements ActionListener{
	
	private ObtenedorSeleccionVista vistaCargarImagen;
	private ObtenedorImagenesMock obtenedorImagenes;
	
	
	public ObtenedorComando()
	{
		vistaCargarImagen = new ObtenedorSeleccionVista();
		vistaCargarImagen.visible(true);
		obtenedorImagenes = new ObtenedorImagenesMock();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vistaCargarImagen.getBtnCerrar())
		{
			vistaCargarImagen.cerrarVentana();
		}
		else if( e.getSource() == vistaCargarImagen.getBtnCargar())
		{
			if(obtenedorImagenes.obtenerImagenes()){
	        vistaCargarImagen.getPanelPrimeraImagen().setIcon(new ImageIcon(obtenedorImagenes.getContenedorImagenes().getPrimerImagen().getRepresentacion()));
	        vistaCargarImagen.getPanelSegundaImagen().setIcon(new ImageIcon(obtenedorImagenes.getContenedorImagenes().getSegundaImagen().getRepresentacion()));
			}

				
		}
		else if( e.getSource() == vistaCargarImagen.getBtnFiltrar())
		{
			
				ResaltadorImagen.resaltarImagen(obtenedorImagenes.getContenedorImagenes().getPrimerImagen(), obtenedorImagenes.getContenedorImagenes().getSegundaImagen(),0,0);
				vistaCargarImagen.getPanelPrimeraImagen().setIcon(new ImageIcon(obtenedorImagenes.getContenedorImagenes().getPrimerImagen().getRepresentacion()));
				vistaCargarImagen.getPanelSegundaImagen().setIcon(new ImageIcon(obtenedorImagenes.getContenedorImagenes().getSegundaImagen().getRepresentacion()));
			}

		}
		
	

}
