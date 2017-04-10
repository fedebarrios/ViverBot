package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.PlantaDTO;

public class ControlSeguimientos {
	private static ControlSeguimientos control;
	private ArrayList<SeguimientoAltura> seguimientos;
	
	private ControlSeguimientos(){
		seguimientos = new ArrayList<SeguimientoAltura>();
	}
	
	public static ControlSeguimientos getInstance(){
		if(control == null ){
			control = new ControlSeguimientos();
		}
		return control;
	}

	public ArrayList<SeguimientoAltura> getSeguimientos() {
		return seguimientos;
	}

	public void setSeguimientos(ArrayList<SeguimientoAltura> seguimientos) {
		this.seguimientos = seguimientos;
	}
	
	public void agregarSeguimiento(PlantaDTO planta, Historial historialOptimo){
		ArrayList<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		Historial h2 = new Historial(tuplas);
		this.seguimientos.add(new SeguimientoAltura(planta, historialOptimo, h2));
	}
	
	public SeguimientoAltura getSeguimiento( PlantaDTO planta ){
		for (int i = 0; i<seguimientos.size() ; i++){
			if( seguimientos.get(i).getPlanta().getCodigo() == planta.getCodigo()
				&& seguimientos.get(i).getPlanta().getCodigoPlanta() == planta.getCodigoPlanta()){
				return seguimientos.get(i);
			}
		}
		return null;
	}
}
