package com.losameos.viverbot.ControladorPlantas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.losameos.viverbot.Controller.Verificacion.Verificador;
import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.Model.Fecha;
import com.losameos.viverbot.Model.Inventario;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.VistasPlantas.Vista_AltaPlanta;

public class Controlador_AltaPlanta implements ActionListener {

	private Vista_AltaPlanta vistaAltaPlanta;
	private Plantas gestorPlantas;
	private ArrayList<EspecieDTO> listaEspecies;
	private Inventario gestorEspecies;

	public Controlador_AltaPlanta(){
		this.gestorEspecies = new Inventario();
		this.gestorPlantas = new Plantas();
		listaEspecies = new ArrayList<EspecieDTO>();
	}
	
	public void inicializar() {
		if (this.vistaAltaPlanta == null) {
			this.vistaAltaPlanta = new Vista_AltaPlanta(this);
			llenarComboEspecies();
		}
		this.vistaAltaPlanta.mostrarVentana();
	}

	public boolean camposValidos() {
		String ubicacion = this.vistaAltaPlanta.getTextUbicacion().getText();
		Date fecha = this.vistaAltaPlanta.getDateFiltro();

		if (ubicacion != "") {
			if (fecha != null) {
				if (!Verificador.fechaFutura(fecha) && Verificador.fechaPosteriorADueño(fecha)) {
					return true;
				} else
					JOptionPane.showMessageDialog(null, "La fecha de plantado es superior a la fecha actual");

			} else
				JOptionPane.showMessageDialog(null, "Complete correctamente el campo Fecha de Plantado");

		} else
			JOptionPane.showMessageDialog(null, "Complete correctamente el campo Ubicacion");
		return false;
	}

	public boolean registrarPlanta() {
		String ubicacion = this.vistaAltaPlanta.getTextUbicacion().getText();
		Fecha fecha = new Fecha(this.vistaAltaPlanta.getDateFiltro().getDay(), this.vistaAltaPlanta.getDateFiltro().getMonth() , this.vistaAltaPlanta.getDateFiltro().getYear());
		int codEspecie = listaEspecies.get(obtenerIndiceSeleccionado()).getCodEspecie();
		return gestorPlantas.agregarPlanta(codEspecie, ubicacion, fecha);
	}

	public void seleccionarUbicacion(String ubicacion) {
		this.vistaAltaPlanta.getTextUbicacion().setText(ubicacion);
	}
	
	public void llenarComboEspecies() {
		listaEspecies = gestorEspecies.obtenerEspecies();
		for(EspecieDTO i: listaEspecies) {
			vistaAltaPlanta.getCmbEspecies().addItem(i.getNombre());
		}
	}
	
	public int obtenerIndiceSeleccionado(){
		return vistaAltaPlanta.getCmbEspecies().getSelectedIndex();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();

		if (evento == this.vistaAltaPlanta.getBtnAceptar()) {
			if (camposValidos()) {
				registrarPlanta();
			}
		}
	}
	
	public Vista_AltaPlanta getVista(){
		return vistaAltaPlanta;
	}
}
