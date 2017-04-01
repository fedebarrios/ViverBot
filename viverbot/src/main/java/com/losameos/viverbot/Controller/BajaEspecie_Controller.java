package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.losameos.viverbot.Model.Inventario;
import com.losameos.viverbot.View.BajaEspecie_View;
import com.losameos.viverbot.dto.EspecieDTO;

public class BajaEspecie_Controller implements ActionListener{
	private BajaEspecie_View bajaVista;
	private Inventario inventario;
	
	public BajaEspecie_Controller(){
		bajaVista = new BajaEspecie_View(this);
		inventario = new Inventario();
		llenarCombo (bajaVista.getComboBox());
		this.bajaVista.setVisible(true);
	}
	
	private void llenarCombo (JComboBox combo){
		ArrayList<EspecieDTO> especies= inventario.obtenerEspecies();
		for(int i = 0; i<especies.size() ; i++) {
			bajaVista.getComboBox().addItem(especies.get(i).getNombre());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.bajaVista.getBtnCancelar()){
			this.bajaVista.dispose();
		}
		else if(e.getSource() == this.bajaVista.getBtnBorrar()){
			String elementoElegido = this.bajaVista.getComboBox().getSelectedItem().toString();
			ArrayList<EspecieDTO> esp= inventario.obtenerEspecies();
			for(int i = 0; i<esp.size() ; i++) {
				if(esp.get(i).getNombre().equals(elementoElegido)){
					this.inventario.borrarEspecie(esp.get(i));
				}
			}
			this.bajaVista.getComboBox().removeAllItems();
			llenarCombo(this.bajaVista.getComboBox());
		}
	}
}
