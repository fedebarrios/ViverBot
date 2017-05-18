package viverbot.Model;

import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.UbicacionDTO;

public class ProtocoloBrazoRobotico {
//Cuando el sistema se enciende debe comprobar 
//si el brazo está en la ubicación de descanso y 
//colocarlo en ese lugar si es que no se encuentra allí.
	private TerrenoDAO terreno;
	
	public ProtocoloBrazoRobotico(){
		terreno = TerrenoDAO.getInstance();
	}
	
	public UbicacionDTO mostrarUbicacionActual(){
		return null;
	}
	
	public boolean ejecutarTarea(Tarea tarea){
		
	}
	
	public boolean estaEnPosicionDescanso(UbicacionDTO ubicacion){
		return terreno.mostrarUbicacionDescanso().equals(ubicacion);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
