package viverbot.Controlador.Imagen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import viverbot.Model.WebCam.ObtenedorImagenesMock;
import viverbot.Modelo.WebCam.Imagen;
import viverbot.Modelo.WebCam.RectificadorImagen;
import viverbot.Vista.Imagen.ObtenedorSeleccionVista;


public class ObtenedorComando implements ActionListener{
	
	private ObtenedorSeleccionVista vistaCargarImagen;
	private ObtenedorImagenesMock obtenedorImagenes;
	private RectificadorImagen resaltadorImagen;
	
	
	public ObtenedorComando()
	{
		vistaCargarImagen = new ObtenedorSeleccionVista();
		vistaCargarImagen.visible(true);
		obtenedorImagenes = new ObtenedorImagenesMock();
		resaltadorImagen = new RectificadorImagen();
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
			
				Imagen imgResaltada = resaltadorImagen.rectificarImagen(obtenedorImagenes.getContenedorImagenes().getPrimerImagen(), obtenedorImagenes.getContenedorImagenes().getSegundaImagen());
				vistaCargarImagen.getPanelPrimeraImagen().setIcon(new ImageIcon(imgResaltada.getRepresentacion()));
				vistaCargarImagen.getPanelSegundaImagen().setIcon(new ImageIcon(obtenedorImagenes.getContenedorImagenes().getSegundaImagen().getRepresentacion()));
			}

		}
		
	

}
