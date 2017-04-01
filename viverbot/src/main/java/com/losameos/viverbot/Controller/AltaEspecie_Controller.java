package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.losameos.viverbot.Model.Inventario;
import com.losameos.viverbot.View.AltaEspecie_View;
import com.losameos.viverbot.dto.EspecieDTO;

public class AltaEspecie_Controller implements ActionListener{
	
	private AltaEspecie_View altaVista;
	public Inventario inventario;
	
	public AltaEspecie_Controller()
	 {
		this.inventario = new Inventario();
		this.altaVista = new AltaEspecie_View(this);
		this.altaVista.setVisible(true);
	 }

	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == this.altaVista.getCancelar_btn()){
			this.altaVista.dispose();
		}
		else if ( e.getSource() == this.altaVista.getGuardar_btn()){
			String nombreEspecie = this.altaVista.getNombreEspecie_tf().getText();
			String nombreCientifico = this.altaVista.getNombreCientifico_tf().getText();
			System.out.println(nombreEspecie);
			System.out.println(nombreCientifico);
			boolean esValido = validar (nombreEspecie);
			if ( !esValido ) {
				JOptionPane.showMessageDialog(this.altaVista, "No ingrese numeros");
			}
			else {
				EspecieDTO nuevaEspecie = new EspecieDTO( nombreEspecie , nombreCientifico , "");
				this.inventario.agregarEspecie(nuevaEspecie);
				JOptionPane.showMessageDialog(this.altaVista, "Se guardo correctamente la nueva especie");
				/*ArrayList<EspecieDTO> esp= inventario.obtenerEspecies();
				for(int i = 0; i<esp.size() ; i++) {
					System.out.println("Iteracion: "+i);
					System.out.println(esp.get(i).getNombre());
					System.out.println(esp.get(i).getNombreCientifico());
				}*/
			}
		}		
	}
	
	public boolean validar (String s){
		for (int i = 0; i<s.length() ; i++){
			if( s.charAt(i) == '0') return false;
			if( s.charAt(i) == '1') return false;
			if( s.charAt(i) == '2') return false;
			if( s.charAt(i) == '3') return false;
			if( s.charAt(i) == '4') return false;
			if( s.charAt(i) == '5') return false;
			if( s.charAt(i) == '6') return false;
			if( s.charAt(i) == '7') return false;
			if( s.charAt(i) == '8') return false;
			if( s.charAt(i) == '9') return false;
		}
		return true;
	}

}
