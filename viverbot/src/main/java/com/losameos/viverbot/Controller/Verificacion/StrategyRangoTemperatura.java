package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Interfaces.IAnalisis;
import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class StrategyRangoTemperatura implements IAnalisis {

	private static RangoNumerico rangoIdeal = new RangoNumerico(10.0, 30.0);

	@Override
	public void analizar(Magnitud temp) {
		RangoNumerico rango = rangoIdeal;
		Temperatura t = (Temperatura)temp;
		EstadoTemperatura estado = new EstadoTemperatura(t, false);
		int resultado = verificarTemperatura(t,  rango);
		if (resultado == 0) {
			estado.setOptima(true);
			System.out.println(
					"la temperatura es: " + estado.getTemperatura().getValor() + " esta dentro del rango ideal");
		} else {
			
			if(resultado == 1){
				estado.setDiferencia( temp.getValor() - rango.getMaximo() );
			}
			else{
				estado.setDiferencia(temp.getValor() -  rango.getMinimo());
				
			}
			
			System.out
					.println("la temperatura es: " + estado.getTemperatura().getValor()
							+ " y no  esta dentro del rango ideal por: " + estado.getDiferencia() + " grados" );
		}
	}
	
	protected int verificarTemperatura(Temperatura t, RangoNumerico rango) {
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
