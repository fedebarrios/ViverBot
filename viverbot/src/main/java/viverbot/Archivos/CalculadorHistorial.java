package viverbot.Archivos;

import java.util.List;

import viverbot.Model.HistorialAltura;
import viverbot.Model.TuplaAltura;

public class CalculadorHistorial {
	
	public static boolean calcularDiferencia(HistorialAltura historial){
		if(!infoRepetida(historial)){
			double alturaAux = 0;
			int diaAux = 0;
			int pos = 0;
			for(TuplaAltura t: historial.getTuplas()){
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
	
	protected static boolean infoRepetida(HistorialAltura historial){
		List<TuplaAltura> tuplas = historial.getTuplas();
		for(int i =0; i < tuplas.size()-1 ; i++){
			for(int j = i+1 ; j < tuplas.size() ; j++){
				if(tuplas.get(i).getDiaDeVida()==tuplas.get(j).getDiaDeVida()){
					return true;
				}
			}
		}
		return false;
	}
}
