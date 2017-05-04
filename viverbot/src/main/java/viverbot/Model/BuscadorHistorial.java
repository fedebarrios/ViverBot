package viverbot.Model;

import viverbot.DTO.PlantaDTO;

public class BuscadorHistorial {

	private ControlSeguimientos seguimientos;
	
	public BuscadorHistorial(ControlSeguimientos control){
		this.seguimientos = control;
	}
	
	public HistorialAltura buscarHistorialOptimo(PlantaDTO planta){
		SeguimientoAltura seguimientoBuscado = this.seguimientos.getSeguimiento(planta);
		return seguimientoBuscado.getHistorialOptimo();
	}
	
	public HistorialAltura buscarHistorialVerdadero(PlantaDTO planta){
		SeguimientoAltura seguimientoBuscado = this.seguimientos.getSeguimiento(planta);
	    return seguimientoBuscado.getHistorialVerdadero();
	}
	
	public SeguimientoAltura buscarSeguimiento(PlantaDTO planta){
		return seguimientos.getSeguimiento(planta);
	}
	
}
