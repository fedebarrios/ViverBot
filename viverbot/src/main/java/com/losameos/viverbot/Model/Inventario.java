package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.Dao.EspecieDao;
import com.losameos.viverbot.dto.EspecieDTO;

public class Inventario {
	private EspecieDao especieDao;
	
	public Inventario(){
		this.especieDao = new EspecieDao();
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
