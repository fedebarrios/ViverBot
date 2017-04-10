package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.View.VistaCambiarUbicacion;

public class UbicacionController implements ActionListener {

	 private VistaCambiarUbicacion vistaCambiarUbicacion;
	// private Ubicacion ubicacion;
	 
	 public UbicacionController(UbicacionDTO ubicacion)
	 {
		 vistaCambiarUbicacion = new VistaCambiarUbicacion(this);
		 
		 //ubicacion = new Ubicacion();

		 vistaCambiarUbicacion.visible(true);		 
		 //cargarDatosUbicacion(ubicacion);
		 //llenarTabla(ubicacion);
	 
		
	 }



		public VistaCambiarUbicacion getVistaCambiarUbicacion() {
			return vistaCambiarUbicacion;
		}
	 
	 
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == vistaCambiarUbicacion.getBtnAceptar())
			{
			//	System.out.println(vistaCambiarUbicacion.filaSeleccionada());	
			}
			else if(e.getSource() == vistaCambiarUbicacion.getBtnCancelar())
			{
				this.vistaCambiarUbicacion.dispose();

			}
			
		}


}
