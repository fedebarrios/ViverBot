package viverbot.Model.Medicion;

import viverbot.Controller.Verificacion.EstadoAltura;
import viverbot.Controller.Verificacion.EstadoAlturaAnormal;
import viverbot.Controller.Verificacion.EstadoAlturaDefectuosa;
import viverbot.Controller.Verificacion.EstadoAlturaNormal;
import viverbot.Controller.Verificacion.EstadoAlturaPerfecta;
import viverbot.DTO.PlantaDTO;

public class BuscadorEstadoAltura {

	private static BuscadorEstadoAltura buscador;
	
	private BuscadorEstadoAltura(){
	};
	
	public static BuscadorEstadoAltura getInstance(){
		if(buscador == null ){
			buscador = new BuscadorEstadoAltura();
		}
		return buscador;
	}
	
	public EstadoAltura obtenerEstado(double valorCrecimiento, double diferenciaAltura , PlantaDTO planta){
		if( valorCrecimiento > 150 ){
			return new EstadoAlturaPerfecta(diferenciaAltura, planta);
		}else if (valorCrecimiento > 90 ){
			return new EstadoAlturaNormal(diferenciaAltura, planta);
		}
		else if (valorCrecimiento > 70 ){
			return new EstadoAlturaAnormal(diferenciaAltura, planta);
		}
		else { 
	    	return new EstadoAlturaDefectuosa(diferenciaAltura , planta);
		}
	}
}
