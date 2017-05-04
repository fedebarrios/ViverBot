package viverbot.Model;

import java.util.ArrayList;


import viverbot.Controller.Verificacion.StubFaltaSeguimiento;
import viverbot.Controller.Verificacion.StubPlantasPerfectas;
import viverbot.Controller.Verificacion.StubSeguimientoAltura;
import viverbot.archivos.GatewaySeguimientos;

import viverbot.DTO.PlantaDTO;

public class ControlSeguimientos {
	private static ControlSeguimientos control;
	private ArrayList<SeguimientoAltura> seguimientos;
	
	private ControlSeguimientos(){
		seguimientos = cargarSeguimientos();
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
	
	public SeguimientoAltura getSeguimiento( PlantaDTO planta ){
		for (int i = 0; i<seguimientos.size() ; i++){
			if( seguimientos.get(i).getPlanta().getCodigo() == planta.getCodigo()
				&& seguimientos.get(i).getPlanta().getCodigoPlanta() == planta.getCodigoPlanta()){
				return seguimientos.get(i);
			}
		}
		return null;
	}
	
	private ArrayList<SeguimientoAltura> cargarSeguimientos(){
		String stub = GatewaySeguimientos.getStub();
		StubSeguimientoAltura seguimientosMock;
		if(stub.equals("StubFaltaSeguimiento")){
			seguimientosMock = new StubFaltaSeguimiento();
		} else if(stub.equals("StubPlantasPerfectas")){
			seguimientosMock = new StubPlantasPerfectas();
		} else{
			seguimientosMock = null;
		}
		
		return seguimientosMock.generarSeguimiento();
	}
}
