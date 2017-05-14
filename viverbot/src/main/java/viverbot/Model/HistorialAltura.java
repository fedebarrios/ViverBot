package viverbot.Model;

import java.util.List;

import viverbot.Modelo.Magnitudes.EmptyMedicion;

public class HistorialAltura {
	
	private List<TuplaAltura> historial;
	
	public HistorialAltura(List<TuplaAltura> lista){
		this.historial = lista;
	}
	
	public int tamaño () {
		return this.historial.size();
	}
	
	public List<TuplaAltura> getTuplas(){
		return historial;
	}

	
	public void agregarTupla(TuplaAltura t){
		historial.add(t);
	}
	
	public void borrarTupla(TuplaAltura t){
		if (historial.contains(t)){
			historial.remove(t);
		}
	}
	
	public TuplaAltura buscarTupla(int d){
		for (int i = 0; i<historial.size() ; i++){
			if(historial.get(i).getDiaDeVida() == d ){
				return historial.get(i);
			}
		}
		return new TuplaAltura(new EmptyMedicion(),0);
	}
	
	public boolean verificarExistente(int dia) {
		for (int i = 0; i<historial.size() ; i++){
			if (historial.get(i).getDiaDeVida() == dia ){
				return true;
			}
		}
		return false;
	}
	
	public int diaUltimaMedicion(){
		if(historial.size()==0){
			return 0;
		} else{
			return historial.get(historial.size()-1).getDiaDeVida();
		}
	}

}
