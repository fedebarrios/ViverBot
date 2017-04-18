package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class StrategyRangoTemperatura implements IAnalisis {

	private EstadoTemperatura estado;
	private RangoNumerico rango;
	private static RangoNumerico rangoIdeal = new RangoNumerico(10.0, 30.0);

	@Override
	public void analizar(Magnitud temp) {
		this.rango = rangoIdeal;
		this.estado = new EstadoTemperatura((Temperatura)temp, false);
		int resultado = verificarTemperatura((Temperatura)temp);
		if (resultado == 0) {
			this.estado.setOptima(true);
			System.out.println(
					"la temperatura es: " + this.estado.getTemperatura().getValor() + " esta dentro del rango ideal");
		} else {
			
			if(resultado == 1){
				this.estado.setDiferencia( temp.getValor() - this.rango.getMaximo() );
			}
			else{
				this.estado.setDiferencia(temp.getValor() -  this.rango.getMinimo());
				
			}
			
			System.out
			.println("la temperatura es: " + this.estado.getTemperatura().getValor() + " y no  esta dentro del rango ideal por: " + this.estado.getDiferencia() + " grados" );
		}
	}
	
	protected int verificarTemperatura(Temperatura t) {
		if(this.rango.getMinimo() <= t.getValor() && this.rango.getMaximo() >= t.getValor()){
			return 0;
		}
		else if(t.getValor() < this.rango.getMinimo()){
			return -1;
		}
		else{
			return 1;
		}
	}

}
