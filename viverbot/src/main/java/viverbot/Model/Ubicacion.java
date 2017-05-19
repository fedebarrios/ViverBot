package viverbot.Model;

import java.util.ArrayList;

import viverbot.DAO.TerrenoDAO;
import viverbot.DTO.UbicacionDTO;

public class Ubicacion {
	
	private TerrenoDAO terrenoDAO;
	
	public Ubicacion()
	{
		inicializar();
	}
	
	public void inicializar(){
		terrenoDAO = new TerrenoDAO();
		terrenoDAO.construirTerreno(10, 5);
	}

	public ArrayList<Object[]> obtenerUbicaciones() {
		UbicacionDTO[][] ubicaciones = terrenoDAO.getUbicaciones();
		ArrayList<Object[]> matriz = new ArrayList<Object[]>();
		for (int i = 0; i < ubicaciones.length; i++) {
			for (int j = 0; j < ubicaciones[i].length; j++) {
				Object[] aux = {i, j, ubicaciones[i][j].isEstado()};
				matriz.add(aux);
			}
		}
		return matriz;
	}
}
