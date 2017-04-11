package com.losameos.viverbot.Model;

import java.util.ArrayList;
import com.losameos.viverbot.DAO.TerrenoDAO;
import com.losameos.viverbot.DAO.UbicacionDAO;
import com.losameos.viverbot.DTO.UbicacionDTO;

public class Ubicacion {
	
	private UbicacionDAO ubicacionDAO;
	private TerrenoDAO terrenoDAO;
	
	public Ubicacion()
	{
		inicializar();
	}
	
	public void inicializar(){
		terrenoDAO = new TerrenoDAO();
		terrenoDAO.construirTerreno(10, 5);
		ubicacionDAO = new UbicacionDAO(terrenoDAO);
	}

	public ArrayList<Object[]> obtenerUbicaciones() {
		UbicacionDTO[][] ubicaciones = ubicacionDAO.mostrarUbicaciones();
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
