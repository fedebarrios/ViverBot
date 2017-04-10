package com.losameos.viverbot.Model;

import java.sql.Date;
import java.util.ArrayList;

import com.losameos.viverbot.DAO.PlantaDAO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.DTO.UbicacionDTO;

public class Plantas {

	private PlantaDAO plantaDAO;

	public Plantas() {
		this.plantaDAO = new PlantaDAO();
	}

	public ArrayList<PlantaDTO> obtenerPlantas(int codEspecie) {
		return plantaDAO.obtenerPlantas(codEspecie);
	}
	
	public ArrayList<PlantaDTO> obtenerPlantas() {
		return plantaDAO.obtenerPlantas();
	}

	public boolean agregarPlanta(int codEspecie, String ubicacion, Date fecha) {
		UbicacionDTO ubicacionDTO = obtenerUbicacion(ubicacion);
		PlantaDTO plantaDTO = new PlantaDTO(codEspecie, plantaDAO.obtenerUltimoCodigo()+1, ubicacionDTO, fecha);
		plantaDAO.agregarPlanta(plantaDTO);
		return false;
	}

	public void eliminarPlanta(int codPlanta) {
		plantaDAO.borrarPlanta(codPlanta);
	}

	public boolean esUbicacionLibre(String ubicacion) {
		return true;
	}

	private UbicacionDTO obtenerUbicacion(String ubicacion) {
		String fila = "";
		String columna = "";
		char aux;
		boolean filaCompleta = false;
		for (int i = 0; i < ubicacion.length(); i++) {
			aux = ubicacion.charAt(i);
			if (aux != ',') {
				fila += aux;
			} else{
				filaCompleta = true;
				continue;
			}
			if (filaCompleta) {
				columna+= aux;
			}
		}
		return new UbicacionDTO(Integer.parseInt(fila), Integer.parseInt(columna));
	}
}
