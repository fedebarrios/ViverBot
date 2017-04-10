package com.losameos.viverbot.Controller.Verificacion;

import java.util.Calendar;

import com.losameos.viverbot.DTO.PlantaDTO;
import com.losameos.viverbot.Model.Historial;
import com.losameos.viverbot.Model.SeguimientoAltura;
import com.losameos.viverbot.Model.TuplaAltura;
import com.losameos.viverbot.Model.Magnitudes.Altura;
import com.losameos.viverbot.Model.Magnitudes.Magnitud;

public class AnalizadorAltura {
	private Historial historialOptimo;
	private Historial historialVerdadero;
	
	
	public AnalizadorAltura(){
		
	}
	
	public void analizar(Magnitud altura, SeguimientoAltura seguimiento){
		this.historialOptimo = seguimiento.getHistorialOptimo();
		this.historialVerdadero = seguimiento.getHistorialVerdadero();
		//Por ahora tomo los minutos, despues habra que ver para ir guardando el dia que se tomo la medicion
		int diaActual = Calendar.getInstance().getTime().getMinutes();
		//TODO: chequear que la misma altura y dia no esten ya en el historial
		this.historialVerdadero.AgregarTupla(new TuplaAltura((Altura) altura, 4));
		TuplaAltura tuplaOptima = historialOptimo.BuscarTupla(diaActual);
		double alturaActual = altura.getValor();
		System.out.println("altura actual : "+alturaActual);
		if( tuplaOptima == null ){
			System.out.println("No se encontro un dia en donde este especificada la altura optima");
		} else if (tuplaOptima.getAltura().getCentimetros() < alturaActual){
			System.out.println("La planta ha crecido mas de lo esperado");
		} else {
			System.out.println("La planta esta creciendo menos de lo esperado");
		}
	}
}
