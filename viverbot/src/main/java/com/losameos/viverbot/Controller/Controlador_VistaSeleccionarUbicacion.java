package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.losameos.viverbot.ControladorPlantas.Controlador_AltaPlanta;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.View.Vista_SeleccionarUbicacion;

public class Controlador_VistaSeleccionarUbicacion implements ActionListener {

	private Vista_SeleccionarUbicacion vistaUbicacion;
	private Ubicacion ubicacion;
	private Controlador_AltaPlanta controlador;

	public Controlador_VistaSeleccionarUbicacion(Controlador_AltaPlanta controlador, Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
		this.controlador = controlador;
		inicializar();
	}
	
	public void inicializar(){
		if(vistaUbicacion==null){
			vistaUbicacion = new Vista_SeleccionarUbicacion(this);
			vistaUbicacion.llenarTabla(ubicacion.obtenerUbicaciones());
		}else{
			vistaUbicacion.llenarTabla(ubicacion.obtenerUbicaciones());
			vistaUbicacion.mostrarVentana();
		}
	}
	
	public Object[] obtenerFilaSeleccionada(int indice){
		return vistaUbicacion.getFilas().get(indice);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vistaUbicacion.getBtnSeleccionar()) {
			int i = vistaUbicacion.getFilaSeleccionada();
			if(i!=-1){
				Object[] aux = obtenerFilaSeleccionada(i);
				String cadena = aux[0] + "," + aux[1];
				controlador.seleccionarUbicacion(cadena);
				this.vistaUbicacion.cerrarVentana();
			}
		} else if (e.getSource() == vistaUbicacion.getBtnCancelar()) {
			this.vistaUbicacion.cerrarVentana();
		}
	}
}
