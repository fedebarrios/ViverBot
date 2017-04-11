package com.losameos.viverbot.Model;

import java.util.ArrayList;

import com.losameos.viverbot.Model.Magnitudes.Altura;

public class HistorialAltura {
	
	private ArrayList<TuplaAltura> historial;
	
	public HistorialAltura(ArrayList<TuplaAltura> lista){
		this.historial = lista;
	}
	
	public int tamaño () {
		return this.historial.size();
	}
	
	public TuplaAltura buscarPorIndice (int indice) {
		TuplaAltura ret;
		try {
			ret = this.historial.get(indice);
		}
		catch (Exception ex){
			ret = null;
		}
		return ret;
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
	
	public boolean verificarExistente(int dia) {
		for (int i = 0; i<historial.size() ; i++){
			if (historial.get(i).getDiaDeVida() == dia ){
				return true;
			}
		}
		return false;
	}

}