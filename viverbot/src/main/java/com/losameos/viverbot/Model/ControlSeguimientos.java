package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Magnitudes.Altura;

public class ControlSeguimientos {
	private static ControlSeguimientos control;
	private ArrayList<SeguimientoAltura> seguimientos;
	
	private ControlSeguimientos(){
		seguimientos = new ArrayList<SeguimientoAltura>();
		ArrayList<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		tuplas.add(new TuplaAltura(new Altura(1.02,"cm"),1));
		HistorialAltura historialOptimo = new HistorialAltura(tuplas);
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(0, 0), historialOptimo);
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
	
	public void agregarSeguimiento(PlantaDTO planta, HistorialAltura historialOptimo){
		ArrayList<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		HistorialAltura h2 = new HistorialAltura(tuplas);
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
