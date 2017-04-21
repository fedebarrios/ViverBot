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
		tuplas.add(new TuplaAltura(new Altura(122,"cm"),1));
		tuplas.add(new TuplaAltura(new Altura(157,"cm"),2));
		tuplas.add(new TuplaAltura(new Altura(179,"cm"),3));
		tuplas.add(new TuplaAltura(new Altura(181,"cm"),4));
		tuplas.add(new TuplaAltura(new Altura(191,"cm"),5));
		tuplas.add(new TuplaAltura(new Altura(199,"cm"),6));
		tuplas.add(new TuplaAltura(new Altura(204,"cm"),7));
		tuplas.add(new TuplaAltura(new Altura(200,"cm"),8));
		tuplas.add(new TuplaAltura(new Altura(197,"cm"),9));
		tuplas.add(new TuplaAltura(new Altura(206,"cm"),10));
		tuplas.add(new TuplaAltura(new Altura(240,"cm"),11));
		tuplas.add(new TuplaAltura(new Altura(230,"cm"),12));
		tuplas.add(new TuplaAltura(new Altura(200,"cm"),13));
		tuplas.add(new TuplaAltura(new Altura(180,"cm"),14));
		HistorialAltura historialOptimo = new HistorialAltura(tuplas);
		this.agregarSeguimiento(new Plantas().obtenerPlantaEspecifica(0), historialOptimo);
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
