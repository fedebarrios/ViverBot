package com.losameos.viverbot.DAO;

import java.util.ArrayList;

import com.losameos.viverbot.DTO.EspecieDTO;

public class EspecieDAO {
	
	private ArrayList<EspecieDTO> especies ;
	public static EspecieDAO especieDAO;
	
	public EspecieDAO() {
		this.especies = new ArrayList<EspecieDTO>();
		this.especies.add(new EspecieDTO(1, "Rosa","Rosus",""));
		this.especies.add(new EspecieDTO(2, "Margarita","Margaritus",""));
		this.especies.add(new EspecieDTO(3, "Amapola","Amapolus",""));
	}
	
	public void agregar(EspecieDTO especie){
		this.especies.add(especie);
	}
	
	public ArrayList<EspecieDTO> leer() {
		return especies;
	}
	
	public void borrarEspecie(int codEspecie){
		int indice=0;
		for( int i = 0; i< especies.size() ; i++){
			if (especies.get(i).getCodEspecie()==codEspecie) indice=i;
		}
		especies.remove(indice);
	}
	
	public int obtenerUltimoCodigo(){
		int longitud = this.especies.size();
		return this.especies.get(longitud-1).getCodEspecie();
	}
	
	public EspecieDTO obtenerEspecie(int codEspecie){
		int longitud = this.especies.size();
		for(int i=0; i<longitud; i++){
			if(especies.get(i).getCodEspecie()==codEspecie) return especies.get(i);
		}
		return null;
	}
	
	public static EspecieDAO getInstance(){                        
		if(especieDAO==null){
			especieDAO = new EspecieDAO();
		}
		return especieDAO;
	}
}
