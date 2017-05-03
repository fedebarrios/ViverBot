package com.losameos.viverbot.Controller.Verificacion;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.HistorialAltura;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.TuplaAltura;

public class StubSeguimientoAltura {
	
	protected ArrayList<SeguimientoAltura> seguimientos;
	
	public void agregarSeguimiento(PlantaDTO planta, HistorialAltura historialOptimo){
		ArrayList<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		HistorialAltura h2 = new HistorialAltura(tuplas);
		this.seguimientos.add(new SeguimientoAltura(planta, historialOptimo, h2));
	}
	
	public ArrayList<SeguimientoAltura> generarSeguimiento(){
		return null;
	}
}
