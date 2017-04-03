package com.losameos.viverbot.Dao;

import java.util.ArrayList;

import com.losameos.viverbot.Model.Tupla;
import com.losameos.viverbot.Model.Ubicacion;
import com.losameos.viverbot.dto.EspecieDTO;
import com.losameos.viverbot.dto.PlantaDTO;

public class PlantaDao {
	
	private ArrayList<Tupla> itemPlanta;
	
	public PlantaDao()
	{
		itemPlanta = new ArrayList<Tupla>();
		inicializar();
	}
	
	private void inicializar()
	{
		for(int i=0; i<5; i++)
		{
			EspecieDTO especie = new EspecieDTO("especie"+i,"cientifico"+i,"imagen"); 
			ArrayList<PlantaDTO> plantas = new ArrayList<PlantaDTO>();
			for(int j=0; j<6; j++)
			{
				PlantaDTO p = new PlantaDTO(new Ubicacion(i*j,i*j));
				plantas.add(p);
			}
			Tupla t = new Tupla(especie,plantas);
			itemPlanta.add(t);
		}
	}
	
	public ArrayList<PlantaDTO> Leer(String e)
	{
		for(Tupla t: itemPlanta)
		{
			if(t.getEspecie().getNombre().equals(e))
				return t.getPlantas();
		}
		return null;
	}
	
	public void Agregar(String especie, PlantaDTO planta)
	{
		for(Tupla t: itemPlanta)
		{
			if(t.getEspecie().getNombre().equals(especie))
				t.agregarPlanta(planta);
		}
	}
	
	public void Eliminar()
	{
		
	}

	public ArrayList<Tupla> getItemPlanta() {
		return itemPlanta;
	}

	public void setItemPlanta(ArrayList<Tupla> itemPlanta) {
		this.itemPlanta = itemPlanta;
	}
	
	
}
