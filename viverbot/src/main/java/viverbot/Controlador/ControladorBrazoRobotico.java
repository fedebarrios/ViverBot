package viverbot.Controlador;

import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.UbicacionDTO;
import viverbot.Modelo.Medicion.AnalizadorCaminoMinimo;

public class ControladorBrazoRobotico {
	private AnalizadorCaminoMinimo analizador;
	private TerrenoDAO terreno;
	
	public ControladorBrazoRobotico(){
		terreno = TerrenoDAO.getInstance();
		analizador = new AnalizadorCaminoMinimo();
		
	}
	
	public boolean moverBrazoAUbicacion(UbicacionDTO ubicacion){
		return true;
	}
	
	
}
