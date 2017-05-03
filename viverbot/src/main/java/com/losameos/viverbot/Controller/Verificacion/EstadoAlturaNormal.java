package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.DTO.PlantaDTO;

public class EstadoAlturaNormal extends EstadoAltura{

	public EstadoAlturaNormal(double cm, PlantaDTO planta){
		this.setEstado("Normal");
		this.setCmDeDiferencia(cm);
		this.setPlanta(planta);
	}
	
	@Override
	public void informar(){
		System.out.println("La planta "+ this.getPlanta().getCodigoPlanta() +" esta creciendo normalmente entre los valores esperados");
	}
}
