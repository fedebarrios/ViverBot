package com.losameos.viverbot.Model;

import com.losameos.viverbot.DTO.PlantaDTO;

public class Podador {
	private static Podador podador;
	
	private Podador(){	
	}
	
	public static Podador getInstance(){
		if (podador==null){
			podador= new Podador();
		}
		return podador;
	}
	
	public boolean podar(PlantaDTO planta){
		System.out.println("Ha llegado una planta para podar");
		System.out.println(planta.getCodigoPlanta()+"el codigo de la planta");
		Plantas plantas = new Plantas();
		if(plantas.obtenerPlantaEspecifica(planta.getCodigoPlanta())==null){
			return false;
		}
		else{
			plantas.eliminarPlanta(planta.getCodigoPlanta());
			return true;
		}
		
	}
}
