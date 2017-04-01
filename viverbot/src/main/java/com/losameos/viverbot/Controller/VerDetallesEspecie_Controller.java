package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.losameos.viverbot.View.VerDetalleEspecie_View;
import com.losameos.viverbot.dto.EspecieDTO;

public class VerDetallesEspecie_Controller implements ActionListener {

	
	 private VerDetalleEspecie_View vistaVerDetalle;
	 
	 public VerDetallesEspecie_Controller(EspecieDTO especie)
	 {
		 vistaVerDetalle = new VerDetalleEspecie_View();
		 vistaVerDetalle.visible(true);
		 vistaVerDetalle.getPanel().llenarTabla(obtenerPlantas());
		 
		 cargarDatosEspecie(especie);
		
	 }
	 
	 private void cargarDatosEspecie(EspecieDTO especie) {
		 vistaVerDetalle.setLlegoNombre(especie.getNombre());
		 vistaVerDetalle.setLlegoNombreC(especie.getNombreCientifico());
		 vistaVerDetalle.setImagenEspecie(especie.getUrlImage());
		 
	}

	private ArrayList<Object[]> obtenerPlantas(){ 
		 
		 //levantar del archivo :: las plantas de tal especie
	 	ArrayList<Object[]> menues = new ArrayList<Object[]>();
			for (int i=0; i<10; i++) {
				
					Object[] o = { "hola", "50", 23};
					menues.add(o);
			}
		return menues;
	 }

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	
		
}
