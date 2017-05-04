package viverbot.Controller.Verificacion;

import java.util.ArrayList;

import viverbot.DTO.PlantaDTO;
import viverbot.Model.HistorialAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Model.SeguimientoAltura;
import viverbot.Model.TuplaAltura;

public class StubSeguimientoAltura {
	
	protected ArrayList<SeguimientoAltura> seguimientos;
	
	public void agregarSeguimiento(PlantaDTO planta, HistorialOptimo historialOptimo){
		ArrayList<TuplaAltura> tuplas = new ArrayList<TuplaAltura>();
		HistorialAltura h2 = new HistorialAltura(tuplas);
		this.seguimientos.add(new SeguimientoAltura(planta, historialOptimo, h2));
	}
	
	public ArrayList<SeguimientoAltura> generarSeguimiento(){
		return null;
	}
}
