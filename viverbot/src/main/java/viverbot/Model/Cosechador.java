package viverbot.Model;

import viverbot.DTO.Planta;

public class Cosechador {
	private static Cosechador podador;
	
	private Cosechador(){	
	}
	
	public static Cosechador getInstance(){
		if (podador==null){
			podador= new Cosechador();
		}
		return podador;
	}
	
	public boolean podar(Planta planta){
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
