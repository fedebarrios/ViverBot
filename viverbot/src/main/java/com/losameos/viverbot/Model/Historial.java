package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.Model.Magnitudes.Altura;

public class Historial {
	
	private ArrayList<TuplaAltura> historial;
	
	public Historial(ArrayList<TuplaAltura> lista){
		this.historial = lista;
	}
	
	public TuplaAltura getTupla(int i){
		return historial.get(i);
	}
	
	public void AgregarTupla(TuplaAltura t){
		historial.add(t);
	}
	
	public void BorrarTupla(TuplaAltura t){
		if (historial.contains(t)){
			historial.remove(t);
		}
	}
	
	public TuplaAltura BuscarTupla(Altura a){
		for (int i = 0; i<historial.size() ; i++){
			if(historial.get(i).getAltura().getCentimetros()==a.getCentimetros()){
				return historial.get(i);
			}
		}
		return null;
	}
	
	public TuplaAltura BuscarTupla(int d){
		for (int i = 0; i<historial.size() ; i++){
			if(historial.get(i).getDiaDeVida() == d ){
				return historial.get(i);
			}
		}
		return null;
	}

}
