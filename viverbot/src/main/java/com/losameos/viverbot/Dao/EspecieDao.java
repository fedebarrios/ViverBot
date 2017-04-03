package com.losameos.viverbot.DAO;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.EspecieDTO;

public class EspecieDao {
	
	private ArrayList<EspecieDTO> especies ;
	
	public EspecieDao() {
		this.especies = new ArrayList<EspecieDTO>();
		this.especies.add(new EspecieDTO("Rosa","Rosus",""));
		this.especies.add(new EspecieDTO("Margarita","Margaritus",""));
		this.especies.add(new EspecieDTO("Amapola","Amapolus",""));
	}
	
	public void Agregar(EspecieDTO especie){
		this.especies.add(especie);
	}
	
	public ArrayList<EspecieDTO> Leer() {
		return especies;
	}
	
	public void Borrar(EspecieDTO especie){
		for( int i = 0; i< especies.size() ; i++){
			if (especies.get(i).getNombre().equals(especie.getNombre())){
				especies.remove(i);
			}
		}
	}

}
