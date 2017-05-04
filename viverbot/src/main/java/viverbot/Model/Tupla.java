package viverbot.Model;

import java.util.ArrayList;

import viverbot.DTO.EspecieDTO;
import viverbot.DTO.PlantaDTO;

public class Tupla<CLAVE,VALOR> {
	
	private CLAVE clave;
	private VALOR valor;
	
	public Tupla(CLAVE t , VALOR s)
	{
		this.clave = t;
		this.valor = s;
	}

	public CLAVE getClave() {
		return clave;
	}

	public void setClave(CLAVE clave) {
		this.clave = clave;
	}

	public VALOR getValor() {
		return valor;
	}

	public void setValor(VALOR valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
