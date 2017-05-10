package viverbot.Controlador.Verificacion;

import viverbot.Interfaces.IAnalisis;
import viverbot.Model.RangoNumerico;
import viverbot.Modelo.Magnitudes.Magnitud;
import viverbot.Modelo.Magnitudes.Medicion;
import viverbot.Modelo.Magnitudes.Temperatura;
import viverbot.Modelo.Medicion.DiagnosticoAnalisis;

public class StrategyRangoTemperatura implements IAnalisis {


	@Override
	public DiagnosticoAnalisis analizar(Medicion t, RangoNumerico rangoIdeal) {
		RangoNumerico rango = rangoIdeal;
		DiagnosticoAnalisis estado = new DiagnosticoAnalisis(t, false);
		int resultado = verificarRango(t,  rango);
		if (resultado == 0) {
			estado.setOptima(true);
			System.out.println(
					"la temperatura es: " + estado.getMagnitud().getValor() + " esta dentro del rango ideal");
		} else {
			
			if(resultado == 1){
				estado.setDiferencia( t.getValor() - rango.getMaximo() );
			}
			else{
				estado.setDiferencia(t.getValor() -  rango.getMinimo());
				
			}
			
			System.out
					.println("la temperatura es: " + estado.getMagnitud().getValor()
							+ " y no  esta dentro del rango ideal por: " + estado.getDiferencia() + " grados" );
		}
		return estado;
	}
	
	protected int verificarRango(Medicion t, RangoNumerico rango) {
		if(rango.getMinimo() <= t.getValor() && rango.getMaximo() >= t.getValor()){
			return 0;
		}
		else if(t.getValor() < rango.getMinimo()){
			return -1;
		}
		else{
			return 1;
		}
	}

}
