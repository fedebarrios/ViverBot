package com.losameos.viverobot.Controller.WebCam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.losameos.viverobot.Model.WebCam.ProcesadorImagen;
import com.losameos.viverobot.VistaWebCam.ComparadorImagenesVista;


public class BuscadorImagenControlador implements ActionListener{
	
	private ComparadorImagenesVista vistaCargarImagen;
	private ProcesadorImagen procesadorImagen;
	
	
	public BuscadorImagenControlador()
	{
		vistaCargarImagen = new ComparadorImagenesVista(this);
		vistaCargarImagen.visible(true);
		procesadorImagen = new ProcesadorImagen();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vistaCargarImagen.getBtnCerrar())
		{
			vistaCargarImagen.cerrarVentana();
		}
		else if( e.getSource() == vistaCargarImagen.getBtnCargar())
		{
			if(procesadorImagen.cargarImagenes()){
	        vistaCargarImagen.getPanelPrimeraImagen().setIcon(new ImageIcon(procesadorImagen.getPrimerImagen().getAtributos().getBuffer()));
	        vistaCargarImagen.getPanelSegundaImagen().setIcon(new ImageIcon(procesadorImagen.getSegundaImagen().getAtributos().getBuffer()));
			}
		}
		else if( e.getSource() == vistaCargarImagen.getBtnFiltrar())
		{
			if(procesadorImagen.getPrimerImagen() != null && procesadorImagen.getSegundaImagen() != null){
	        vistaCargarImagen.getPanelPrimeraImagen().setIcon(new ImageIcon(procesadorImagen.resaltarObjetos().getAtributos().getBuffer()));
	        vistaCargarImagen.getPanelSegundaImagen().setIcon(new ImageIcon(procesadorImagen.getSegundaImagen().getAtributos().getBuffer()));
			}
			else
				JOptionPane.showMessageDialog(null,"No ha cargado ninguna imagen.");

		}
		
	}
	

}
