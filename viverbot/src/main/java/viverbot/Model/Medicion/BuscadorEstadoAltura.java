package viverbot.Model.Medicion;

import java.util.ArrayList;

import viverbot.Controller.Verificacion.EstadoAltura;
import viverbot.Controller.Verificacion.EstadoAlturaAnormal;
import viverbot.Controller.Verificacion.EstadoAlturaDefectuosa;
import viverbot.Controller.Verificacion.EstadoAlturaNormal;
import viverbot.Controller.Verificacion.EstadoAlturaPerfecta;
import viverbot.DTO.PlantaDTO;

public class BuscadorEstadoAltura {
	
	private ArrayList<Integer> porcentajesDeCrecimiento;
	private ArrayList<EstadoAltura> estados;
	private static BuscadorEstadoAltura buscador;
	
	private BuscadorEstadoAltura(){
		//Luego lo hara otra clase encargada de levantar la info de un txt
		this.porcentajesDeCrecimiento = new ArrayList<Integer>();
		this.estados = new ArrayList<EstadoAltura>();
		cargarArreglos(porcentajesDeCrecimiento, estados);
	};
	
	public static BuscadorEstadoAltura getInstance(){
		if(buscador == null ){
			buscador = new BuscadorEstadoAltura();
		}
		return buscador;
	}
	
	public EstadoAltura obtenerEstado(double valorCrecimiento, double diferenciaAltura , PlantaDTO planta){
		int i = 0;
		EstadoAltura estado = null;
		for (Integer porcentaje : porcentajesDeCrecimiento){
			if (valorCrecimiento < porcentaje){
				estado= estados.get(i);
				estado.setCmDeDiferencia(diferenciaAltura);
				estado.setPlanta(planta);
				break;
			}			
			i++;			
		}
		return estado;
	}
	
	private void cargarArreglos(ArrayList<Integer> a1, ArrayList<EstadoAltura> a2){
		a1.add(70);
		a1.add(90);
		a1.add(150);
		
		a2.add(new EstadoAlturaDefectuosa(0, null));
		a2.add(new EstadoAlturaAnormal(0, null));
		a2.add(new EstadoAlturaNormal(0, null));
		a2.add(new EstadoAlturaPerfecta(0, null));		
	}
}
