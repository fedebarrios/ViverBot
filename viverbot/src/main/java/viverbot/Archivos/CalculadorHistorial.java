package viverbot.Archivos;

import java.util.Map;
import java.util.Map.Entry;

import viverbot.DTO.Especie;
import viverbot.Model.HistorialAltura;
import viverbot.Model.HistorialOptimo;
import viverbot.Modelo.Magnitudes.Medicion;

public class CalculadorHistorial {

	public static boolean calcularDiferencia(HistorialAltura h) {
		double alturaAux = 0;
		int diaAux = 0;
		int pos = 0;
		for (Entry<Integer, Medicion> registro : h.getEntrySet()) {
			if (pos == 0) {
				System.out.println("entro al if");
				alturaAux = registro.getValue().getValor();
				diaAux = registro.getKey();
			} else {
				double diferenciaAltura = registro.getValue().getValor() - alturaAux;
				int diferenciaDias = registro.getKey() - diaAux;
				if (diferenciaAltura > ValoresCalculador.diferenciaAltura
						|| diferenciaDias > ValoresCalculador.diferenciaDias) {
					return false;
				}
			}
			pos++;
		}
		return true;
	}

	public static boolean hayInfoValida(HistorialOptimo historialOptimo, Especie especie) {
		return especie != null;
	}
}
