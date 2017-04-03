package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.View.VerDetalleEspecie;

public class VerDetallesEspecieController implements ActionListener {

	
	 private VerDetalleEspecie vistaVerDetalle;
	 private Plantas plantas;
	 
	 public VerDetallesEspecieController(EspecieDTO especie)
	 {
		 vistaVerDetalle = new VerDetalleEspecie(this);
		 plantas = new Plantas();
		 vistaVerDetalle.visible(true);		 
		 cargarDatosEspecie(especie);
		 llenarTabla();
		 
		
	 }
	 
	 private void cargarDatosEspecie(EspecieDTO especie) {
		 vistaVerDetalle.setLlegoNombre(especie.getNombre());
		 vistaVerDetalle.setLlegoNombreC(especie.getNombreCientifico());
		 vistaVerDetalle.setImagenEspecie(especie.getUrlImage());
		 
	}
	 
	private void llenarTabla()
	{
		//aca va el nombre de la especie recibida que 'exista'
		ArrayList<PlantaDTO> listadoPlantas = plantas.obtenerPlantas("especie3");
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
