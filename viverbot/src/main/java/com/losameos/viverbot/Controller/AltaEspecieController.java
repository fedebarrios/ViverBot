package com.losameos.viverbot.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.Model.Inventario;
import com.losameos.viverbot.View.AltaEspecie;

public class AltaEspecieController implements ActionListener{
	
	private AltaEspecie altaVista;
	public Inventario inventario;
	
	public AltaEspecieController()
	 {
		this.inventario = new Inventario();
		this.altaVista = new AltaEspecie(this);
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
				String pathAlmacenado = copiar(this.altaVista.getImagen_tf().getText(), nombreEspecie);
				EspecieDTO nuevaEspecie = new EspecieDTO( nombreEspecie , nombreCientifico , pathAlmacenado);
				this.inventario.agregarEspecie(nuevaEspecie);
				JOptionPane.showMessageDialog(this.altaVista, "Se guardo correctamente la nueva especie");
				this.altaVista.getNombreEspecie_tf().setText("");
				this.altaVista.getNombreCientifico_tf().setText("");
				this.altaVista.getImagen_tf().setText("");
			}
		}		
	}
	
	private boolean validar (String s){
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
	
	 private String copiar(String origen, String destino){
	        File archivoOrigen = new File(origen);
	        String extension = origen.substring(origen.length()-4, origen.length());
	        String pathNuevo = "src/main/java/Recursos/"+destino+extension;
	        File archivoDestino = new File(pathNuevo);
	        archivoOrigen.renameTo(archivoDestino);
	        return pathNuevo;
	 }
}
