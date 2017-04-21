package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Interfaces.IAnalisis;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.DiagnosticoAnalisis;

public class StrategyRangoTemperatura implements IAnalisis {


	@Override
	public DiagnosticoAnalisis analizar(Magnitud t, RangoNumerico rangoIdeal) {
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
	
	protected int verificarRango(Magnitud t, RangoNumerico rango) {
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
