package com.losameos.viverbot.ControladorPlantas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.VistasPlantas.Vista_AltaPlanta;

public class Controlador_AltaPlanta implements ActionListener{
	
	private Vista_AltaPlanta vistaAltaPlanta;
	private Plantas modeloPlantas;
	
	public void inicializar() {
		if (this.vistaAltaPlanta == null) {
			this.vistaAltaPlanta = new Vista_AltaPlanta(this);
		}
		this.vistaAltaPlanta.mostrarVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
	}
}
