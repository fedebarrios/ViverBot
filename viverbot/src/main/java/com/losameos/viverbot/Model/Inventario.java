package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.DAO.EspecieDAO;
import com.losameos.viverbot.DTO.EspecieDTO;

public class Inventario {
	private EspecieDAO especieDao;
	
	public Inventario(){
		this.especieDao = new EspecieDAO();
	}
	
	public ArrayList<EspecieDTO> obtenerEspecies(){
		return especieDao.Leer();
	}
	
	public void agregarEspecie(EspecieDTO especie){
		especieDao.Agregar(especie);
	}
	
	public void borrarEspecie(EspecieDTO especie){
		especieDao.Borrar(especie);
	}
}
