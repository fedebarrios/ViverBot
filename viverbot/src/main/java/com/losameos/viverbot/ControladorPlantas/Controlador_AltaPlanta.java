package com.losameos.viverbot.ControladorPlantas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import com.losameos.viverbot.Controller.Verificacion.Verificador;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.VistasPlantas.Vista_AltaPlanta;

public class Controlador_AltaPlanta implements ActionListener {

	private Vista_AltaPlanta vistaAltaPlanta;
	private Plantas modeloPlantas;

	public void inicializar() {
		if (this.vistaAltaPlanta == null) {
			this.vistaAltaPlanta = new Vista_AltaPlanta(this);
		}
		this.vistaAltaPlanta.mostrarVentana();
		modeloPlantas = new Plantas();
	}

	public boolean camposValidos() {
		String ubicacion = this.vistaAltaPlanta.getTextUbicacion().getText();
		Date fecha = this.vistaAltaPlanta.getDateFiltro();

		if (ubicacion != "") {
			if (ubicacionLibre(ubicacion)) {
				if (fecha != null) {
					if (!Verificador.fechaFutura(fecha) && Verificador.fechaPosteriorADueño(fecha)) {
						return true;
					} else
						JOptionPane.showMessageDialog(null, "La fecha de plantado es superior a la fecha actual");

				} else
					JOptionPane.showMessageDialog(null, "Complete correctamente el campo Fecha de Plantado");
			} else
				JOptionPane.showMessageDialog(null, "La ubicacion seleccionada se encuentra ocupada");

		} else
			JOptionPane.showMessageDialog(null, "Complete correctamente el campo Ubicacion");
		return false;
	}

	public boolean ubicacionLibre(String ubicacion) {
		return modeloPlantas.ubicacionLibre(ubicacion);
	}

	public boolean registrarPlanta() {
		String ubicacion = this.vistaAltaPlanta.getTextUbicacion().getText();
		Date fecha = this.vistaAltaPlanta.getDateFiltro();
		return modeloPlantas.agregarPlanta(2, ubicacion, fecha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();

		if (evento == this.vistaAltaPlanta.getBtnAceptar()) {
			if (camposValidos()) {

			}
		}
	}
}
