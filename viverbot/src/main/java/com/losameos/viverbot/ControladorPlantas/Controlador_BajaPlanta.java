package com.losameos.viverbot.ControladorPlantas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Inventario;
import com.losameos.viverbot.Model.Plantas;
import com.losameos.viverbot.VistasPlantas.Vista_BajaPlanta;

public class Controlador_BajaPlanta implements ActionListener{

	private Vista_BajaPlanta vistaBajaPlanta;
	private ArrayList<PlantaDTO> listaPlantas;
	private Plantas gestorPlantas;
	private Inventario inventario;
	
	public Controlador_BajaPlanta(Plantas gestorPlantas){
		this.gestorPlantas = gestorPlantas;
		this.inventario = new Inventario();
	}
	
	public void inicializar(){
		if(this.vistaBajaPlanta!=null){
			this.vistaBajaPlanta = new Vista_BajaPlanta(this);
			llenarComboPlantas();
			this.vistaBajaPlanta.mostrarVentana();
		}
		else{
			this.vistaBajaPlanta.mostrarVentana();
			this.vistaBajaPlanta.limpiarVista();
			llenarComboPlantas();
		}
	}
	
	public void llenarComboPlantas() {
		listaPlantas = gestorPlantas.obtenerPlantas();
		String aux;
		for(PlantaDTO i: listaPlantas) {
			aux = this.inventario.obtenerEspecie(i.getCodigo()).getNombre();
			vistaBajaPlanta.getCmbPlantas().addItem(aux);
		}
	}
	
	public int obtenerIndiceSeleccionado(){
		return this.vistaBajaPlanta.getCmbPlantas().getSelectedIndex();
	}
	
	public void borrarItemPlanta(int i){
		this.vistaBajaPlanta.getCmbPlantas().remove(i);
		this.vistaBajaPlanta.limpiarVista();
		this.llenarComboPlantas();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		if(evento == this.vistaBajaPlanta.getBtnCancelar()){
			this.vistaBajaPlanta.cerrarVentana();
		}else if(evento == this.vistaBajaPlanta.getBtnBorrar()){
			int indice = obtenerIndiceSeleccionado();
			if(indice>=0){
				borrarItemPlanta(indice);
			}else{
				JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna planta");
			}
		}
	}
}
