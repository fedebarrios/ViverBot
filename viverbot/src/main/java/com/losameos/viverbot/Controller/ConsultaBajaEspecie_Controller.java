package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.Model.Inventario;
import com.losameos.viverbot.View.ConsultaBajaEspecie;

public class ConsultaBajaEspecie_Controller implements ActionListener {
	private ConsultaBajaEspecie consultaBajaVista;
	private Inventario inventario;

	public ConsultaBajaEspecie_Controller() {
		consultaBajaVista = new ConsultaBajaEspecie(this);
		inventario = new Inventario();
		llenarCombo(consultaBajaVista.getComboBox());
		this.consultaBajaVista.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void llenarCombo(@SuppressWarnings("rawtypes") JComboBox combo) {
		ArrayList<EspecieDTO> especies = inventario.obtenerEspecies();
		for (int i = 0; i < especies.size(); i++) {
			consultaBajaVista.getComboBox().addItem(especies.get(i).getNombre());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.consultaBajaVista.getBtnCancelar()) {
			this.consultaBajaVista.dispose();
		} else if (e.getSource() == this.consultaBajaVista.getBtnBorrar()) {
			String elementoElegido = this.consultaBajaVista.getComboBox().getSelectedItem().toString();
			ArrayList<EspecieDTO> esp = inventario.obtenerEspecies();
			for (int i = 0; i < esp.size(); i++) {
				if (esp.get(i).getNombre().equals(elementoElegido)) {
					this.inventario.borrarEspecie(esp.get(i).getCodEspecie());
				}
			}
			this.consultaBajaVista.getComboBox().removeAllItems();
			llenarCombo(this.consultaBajaVista.getComboBox());
		} else if (e.getSource() == this.consultaBajaVista.getBtnVerDetalle()){
			//TODO: levantar la vista del detalle
		}
	}
}
