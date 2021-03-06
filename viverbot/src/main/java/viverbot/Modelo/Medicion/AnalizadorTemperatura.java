package viverbot.Modelo.Medicion;

import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.EmptyMedicion;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;

public class AnalizadorTemperatura {

	public static DiagnosticoAnalisis analizar(Medicion t, RangoNumerico rango) throws MedicionVacioException {
		DiagnosticoAnalisis estado;

		if(t.getTipo() == Magnitud.VACIO){
			throw new MedicionVacioException();
		}
		else{
			int resultado = verificarTemperaturaEnRango(t, rango);
			if (resultado == 0) {
				estado = new DiagnosticoAnalisis(t, true, 0.0);
			} else {
				if (resultado == 1) {
					estado = new DiagnosticoAnalisis(t, false, t.getValor() - rango.getMaximo());
				} else {
					estado = new DiagnosticoAnalisis(t, false, t.getValor() - rango.getMinimo());
				}
			}
			return estado;
		}
		

	}

	private static int verificarTemperaturaEnRango(Medicion t, RangoNumerico rango) {
		System.out.println(rango.getMinimo() + " " + t.getValor());
		if (rango.getMinimo() <= t.getValor() && rango.getMaximo() >= t.getValor()) {
			return 0;
		} else if (t.getValor() < rango.getMinimo()) {
			return -1;
		} else {
			return 1;
		}
	}

}
