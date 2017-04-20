package com.losameos.viverobot.Controller.WebCam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.losameos.viverobot.Model.WebCam.Imagen;
import com.losameos.viverobot.Model.WebCam.ObtenedorImagenes;
import com.losameos.viverobot.Model.WebCam.ResaltadorImagen;
import com.losameos.viverobot.VistaWebCam.ObtenedorSeleccionVista;


public class ObtenedorComando implements ActionListener{
	
	private ObtenedorSeleccionVista vistaCargarImagen;
	private ObtenedorImagenes obtenedorImagenes;
	private ResaltadorImagen resaltadorImagen;
	
	
	public ObtenedorComando()
	{
		vistaCargarImagen = new ObtenedorSeleccionVista(this);
		vistaCargarImagen.visible(true);
		obtenedorImagenes = new ObtenedorImagenes();
		resaltadorImagen = new ResaltadorImagen();
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
			else
				JOptionPane.showMessageDialog(null,"No se ha podido cargar las imagenes.");

				
		}
		else if( e.getSource() == vistaCargarImagen.getBtnFiltrar())
		{
			
				Imagen imgResaltada = resaltadorImagen.resaltarImagen(obtenedorImagenes.getContenedorImagenes());
				vistaCargarImagen.getPanelPrimeraImagen().setIcon(new ImageIcon(imgResaltada.getRepresentacion()));
				vistaCargarImagen.getPanelSegundaImagen().setIcon(new ImageIcon(obtenedorImagenes.getContenedorImagenes().getSegundaImagen().getRepresentacion()));
			}
			else
				JOptionPane.showMessageDialog(null,"No ha cargado ninguna imagen.");

		}
		
	

}
