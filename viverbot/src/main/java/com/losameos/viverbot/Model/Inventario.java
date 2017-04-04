package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.DAO.EspecieDAO;
import com.losameos.viverbot.DTO.EspecieDTO;

public class Inventario {
	private EspecieDAO especieDAO;
	
	public Inventario(){
		this.especieDAO = new EspecieDAO();
	}
	
	public ArrayList<EspecieDTO> obtenerEspecies(){
		return especieDAO.Leer();
	}
	
	public void agregarEspecie(EspecieDTO especie){
		especieDAO.Agregar(especie);
	}
	
	public void borrarEspecie(EspecieDTO especie){
		especieDAO.Borrar(especie);
	}
}
