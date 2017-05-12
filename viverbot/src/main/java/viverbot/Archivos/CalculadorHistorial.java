package viverbot.Archivos;

import viverbot.Model.HistorialAltura;
import viverbot.Model.TuplaAltura;

public class CalculadorHistorial {
	
	public static boolean calcularDiferencia(HistorialAltura historial){
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
				if(diferenciaAltura>0.20 || diferenciaDias > 5){
					return false;
				}
			}
			pos++;
		}
		return true;
	}
}
