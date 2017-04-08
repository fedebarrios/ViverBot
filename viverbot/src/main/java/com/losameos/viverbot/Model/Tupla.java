package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.DTO.PlantaDTO;

public class Tupla {
	
	private EspecieDTO especie;
	private ArrayList<PlantaDTO> plantas;
	
	public Tupla(EspecieDTO especie, ArrayList<PlantaDTO> plantas)
	{
		this.especie = especie;
		this.plantas = plantas;
	}
	
	public void agregarPlanta(PlantaDTO planta)
	{
		plantas.add(planta);
	}
	public void eliminarPlanta()
	{
		
	}
	public EspecieDTO getEspecie() {
		return especie;
	}

	public void setEspecie(EspecieDTO especie) {
		this.especie = especie;
	}

	public ArrayList<PlantaDTO> getPlantas() {
		return plantas;
	}

	public void setPlantas(ArrayList<PlantaDTO> plantas) {
		this.plantas = plantas;
	}
	

}
