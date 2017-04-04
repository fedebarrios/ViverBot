package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.DAO.PlantaDAO;
import com.losameos.viverbot.DTO.PlantaDTO;

public class Plantas {
	
	private PlantaDAO plantaDAO;
	
	public Plantas()
	{
		this.plantaDAO = new PlantaDAO();
	}
	
	public ArrayList<PlantaDTO> obtenerPlantas(String especie)
	{
		return plantaDAO.Leer(especie);
	}
	
	public void agregarPlanta(String especie, PlantaDTO nuevaPlanta)
	{
		plantaDAO.Agregar(especie,nuevaPlanta);
	}
	
	public void eliminarPlanta()
	{
		plantaDAO.Eliminar();
	}

}
