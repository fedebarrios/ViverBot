package viverbot.Archivos;

import java.util.List;

import viverbot.DTO.Especie;
import viverbot.Model.TuplaAltura;

public class CalculadorHistorial {
	
	public static boolean calcularDiferencia(List<TuplaAltura> tuplas){
		if(!infoRepetida(tuplas)){
			double alturaAux = 0;
			int diaAux = 0;
			int pos = 0;
			for(TuplaAltura t: tuplas){
				if(pos == 0){
					alturaAux = t.getAltura().getValor();
					diaAux = t.getDiaDeVida();
				}
				else{
					double diferenciaAltura = t.getAltura().getValor() - alturaAux;
					int diferenciaDias = t.getDiaDeVida() - diaAux;
					if(diferenciaAltura> ValoresCalculador.diferenciaAltura 
					|| diferenciaDias > ValoresCalculador.diferenciaDias){
						return false;
					}
				}
				pos++;
			}
			return true;
		}
		return false;
	}
	
	protected static boolean infoRepetida(List<TuplaAltura> tuplasHistorial){
		for(int i =0; i < tuplasHistorial.size()-1 ; i++){
			for(int j = i+1 ; j < tuplasHistorial.size() ; j++){
				if(tuplasHistorial.get(i).getDiaDeVida()==tuplasHistorial.get(j).getDiaDeVida()){
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hayInfoValida(List<TuplaAltura> lista, Especie especie) {
		return especie!=null;
	}
}
