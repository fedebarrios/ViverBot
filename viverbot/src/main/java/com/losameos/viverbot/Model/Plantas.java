package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.DAO.PlantaDao;
import com.losameos.viverbot.DTO.PlantaDTO;

public class Plantas {
	
	private PlantaDao plantaDao;
	
	public Plantas()
	{
		this.plantaDao = new PlantaDao();
	}
	
	public ArrayList<PlantaDTO> obtenerPlantas(String especie)
	{
		return plantaDao.Leer(especie);
	}
	
	public void agregarPlanta(String especie, PlantaDTO nuevaPlanta)
	{
		plantaDao.Agregar(especie,nuevaPlanta);
	}
	
	public void eliminarPlanta()
	{
		plantaDao.Eliminar();
	}

}
