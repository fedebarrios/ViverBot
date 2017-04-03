package com.losameos.viverbot.DAO;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.EspecieDTO;
import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Tupla;
import com.losameos.viverbot.Model.Ubicacion;

public class PlantaDAO {
	
	private ArrayList<Tupla> itemPlanta;
	
	public PlantaDAO()
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
