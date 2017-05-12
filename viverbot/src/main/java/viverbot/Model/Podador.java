package viverbot.Model;

import viverbot.DTO.PlantaDTO;

public class Podador {
	private static Podador podador;
	
	private Podador(){	
	}
	
	public static Podador getInstance(){
		if (podador==null){
			podador= new Podador();
		}
		return podador;
	}
	
	public boolean podar(PlantaDTO planta){
		Plantas plantas = new Plantas();
		if(plantas.obtenerPlantaEspecifica(planta.getCodigoPlanta())==null){
			return false; 
		}
		else{
			plantas.eliminarPlanta(planta.getCodigoPlanta());
			return true;
		}
		
	}
}
