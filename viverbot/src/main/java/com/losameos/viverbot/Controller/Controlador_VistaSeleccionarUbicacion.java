package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.losameos.viverbot.DTO.UbicacionDTO;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.View.Vista_SeleccionarUbicacion;

public class Controlador_VistaSeleccionarUbicacion implements ActionListener {

	private Vista_SeleccionarUbicacion vistaCambiarUbicacion;
	private Ubicacion ubicacion;

	public Controlador_VistaSeleccionarUbicacion() {
		inicializar();
	}
	
	public void inicializar(){
		if(vistaCambiarUbicacion==null){
			vistaCambiarUbicacion = new Vista_SeleccionarUbicacion(this);
			
		}else{
			vistaCambiarUbicacion.mostrarVentana();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == null) {
			// System.out.println(vistaCambiarUbicacion.filaSeleccionada());
		} else if (e.getSource() == vistaCambiarUbicacion.getBtnCancelar()) {
			this.vistaCambiarUbicacion.dispose();
		}
	}
}
