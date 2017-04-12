package com.losameos.viverbot.Controller.Verificacion;

import com.losameos.viverbot.Model.RangoNumerico;
import com.losameos.viverbot.Model.Magnitudes.Temperatura;
import com.losameos.viverbot.Model.Medicion.EstadoTemperatura;

public class AnalizadorTemperatura {
	private EstadoTemperatura estado;
	private RangoNumerico rango;
	private static RangoNumerico rangoIdeal = new RangoNumerico(10.0, 30.0);

	public AnalizadorTemperatura() {
		this.rango = this.obtenerRango();
		this.estado = null;
	}

	private RangoNumerico obtenerRango() {
		return rangoIdeal;
	}

	public void analizar(Temperatura temperaturaActual) {
		this.estado = new EstadoTemperatura(temperaturaActual, false);
		int resultado = verificarTemperatura(temperaturaActual);
		if (resultado == 0) {
			this.estado.setOptima(true);
			System.out.println(
					"la temperatura es: " + this.estado.getTemperatura().getValor() + " esta dentro del rango ideal");
		} else {
			
			if(resultado == 1){
				this.estado.setDiferencia( temperaturaActual.getValor() - this.rango.getMaximo() );
			}
			else{
				this.estado.setDiferencia(temperaturaActual.getValor() -  this.rango.getMinimo());
				
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
	
	

	public EstadoTemperatura getEstado() {
		return estado;
	}

	public RangoNumerico getRango() {
		return rango;
	}

	

	public void setEstado(EstadoTemperatura estado) {
		this.estado = estado;
	}

	public void setRango(RangoNumerico rango) {
		this.rango = rango;
	}
	

	
}
