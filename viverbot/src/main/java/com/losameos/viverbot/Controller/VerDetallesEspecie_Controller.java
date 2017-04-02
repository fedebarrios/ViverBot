package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.View.VerDetalleEspecie;
import com.losameos.viverbot.dto.EspecieDTO;
import com.losameos.viverbot.dto.PlantaDTO;

public class VerDetallesEspecie_Controller implements ActionListener {

	
	 private VerDetalleEspecie vistaVerDetalle;
	 private Plantas plantas;
	 
	 public VerDetallesEspecie_Controller(EspecieDTO especie)
	 {
		 vistaVerDetalle = new VerDetalleEspecie(this);
		 plantas = new Plantas();
		 vistaVerDetalle.visible(true);		 
		 cargarDatosEspecie(especie);
		 llenarTabla(especie);
		 
		
	 }
	 
	 private void cargarDatosEspecie(EspecieDTO especie) {
		 vistaVerDetalle.setLlegoNombre(especie.getNombre());
		 vistaVerDetalle.setLlegoNombreC(especie.getNombreCientifico());
		 vistaVerDetalle.setImagenEspecie(especie.getUrlImage());
		 
	}
	 
	private void llenarTabla(EspecieDTO especie)
	{
	
		ArrayList<PlantaDTO> listadoPlantas = plantas.obtenerPlantas(especie.getNombre());
		for(PlantaDTO p: listadoPlantas)
		{
			Object[] obj = { p.getUbicacion().getFila(), p.getUbicacion().getColumna()};
			vistaVerDetalle.getPanel().agregarFila(obj);

		}
	}


		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == vistaVerDetalle.getBtnRevivir())
			{
				System.out.println(vistaVerDetalle.filaSeleccionada());
			}
			else if(e.getSource() == vistaVerDetalle.getBtnEliminar())
			{
				
			}
			
		}

		public VerDetalleEspecie getVistaVerDetalle() {
			return vistaVerDetalle;
		}

		public void setVistaVerDetalle(VerDetalleEspecie vistaVerDetalle) {
			this.vistaVerDetalle = vistaVerDetalle;
		}

		public Plantas getPlantas() {
			return plantas;
		}

		public void setPlantas(Plantas plantas) {
			this.plantas = plantas;
		}
	
		
}
