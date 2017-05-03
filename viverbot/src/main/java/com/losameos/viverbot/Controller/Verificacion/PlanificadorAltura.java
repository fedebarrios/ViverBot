package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.LectorConsola;
import com.losameos.viverbot.Model.SoporteFactory;
import com.losameos.viverbot.Model.SoporteMovible;
import com.losameos.viverbot.Model.Magnitudes.Magnitudes;


public class PlanificadorAltura {
	private static PlanificadorAltura planificador;
	private SoporteMovible soporte;
	
	private PlanificadorAltura(){
		this.soporte = SoporteFactory.crearSoporte(Magnitudes.ALTURA);
	}
	
	public static PlanificadorAltura getInstance(){
		if(planificador == null ){
			planificador = new PlanificadorAltura();
		}
		return planificador;
	}
	
	public void actuar(EstadoAltura estado){
		estado.informar();
		
		if( estado.getEstado() == "Defectuosa"){
			System.out.println("Ingrese Si, si desea podar la planta");
			String entradaTeclado = LectorConsola.getInstance().leerLinea();
		    if(entradaTeclado.equals("si")){
		    	if(soporte.getPodador().podar(estado.getPlanta())){
					System.out.println("La planta "+ estado.getPlanta().getCodigoPlanta()+" se ha podado");
				}
				else{
					System.out.println("No se pudo podar la planta "+ estado.getPlanta().getCodigoPlanta());
				}
		    }
		    else{
		    	System.out.println("La planta no se podo");
		    }
		}
	}
}
